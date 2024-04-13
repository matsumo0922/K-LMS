package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlannerNoteEntity(
    // The ID of the planner note
    @SerialName("id")
    val id: Int,
    // The title for a planner note
    @SerialName("title")
    val title: String,
    // The description of the planner note
    @SerialName("description")
    val description: String?, // Assuming description can be optional

    // The id of the associated user creating the planner note
    @SerialName("user_id")
    val userId: Int,
    // The current published state of the planner note
    @SerialName("workflow_state")
    val workflowState: String,
    // The course that the note is in relation to
    @SerialName("course_id")
    val courseId: Int?,
    // The datetime of when the planner note should show up
    @SerialName("todo_date")
    val todoDate: String,
    // The type of the linked learning object
    @SerialName("linked_object_type")
    val linkedObjectType: String,
    // The id of the linked learning object
    @SerialName("linked_object_id")
    val linkedObjectId: Int,
    // The Canvas web URL of the linked learning object
    @SerialName("linked_object_html_url")
    val linkedObjectHtmlUrl: String,
    // The API URL of the linked learning object
    @SerialName("linked_object_url")
    val linkedObjectUrl: String,
)
