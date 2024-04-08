package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlannerOverrideEntity(
    // The ID of the planner override
    @SerialName("id")
    val id: Int,

    // The type of the associated object
    @SerialName("plannable_type")
    val plannableType: String,

    // The id of the associated object
    @SerialName("plannable_id")
    val plannableId: Int,

    // The id of the associated user
    @SerialName("user_id")
    val userId: Int,

    // The id of the plannable's associated assignment
    @SerialName("assignment_id")
    val assignmentId: Int?, // Assuming this can be null

    // The current published state of the item
    @SerialName("workflow_state")
    val workflowState: String,

    // Whether the item is marked complete or not
    @SerialName("marked_complete")
    val markedComplete: Boolean,

    // Controls whether or not the item shows up in the opportunities list
    @SerialName("dismissed")
    val dismissed: Boolean,

    // The datetime of when the planner override was created
    @SerialName("created_at")
    val createdAt: String,

    // The datetime of when the planner override was updated
    @SerialName("updated_at")
    val updatedAt: String,

    // The datetime of when the planner override was deleted
    @SerialName("deleted_at")
    val deletedAt: String?
)
