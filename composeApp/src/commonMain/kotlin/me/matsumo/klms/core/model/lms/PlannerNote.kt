package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlannerNote(
        val id: Int,

        val title: String,

        val description: String?, 
        val userId: Int,

        val workflowState: String,

        val courseId: Int?,

        val todoDate: Instant,

        val linkedObjectType: String,

        val linkedObjectId: Int,

        val linkedObjectHtmlUrl: String,

        val linkedObjectUrl: String
)

fun PlannerNoteEntity.translate(): PlannerNote {
    return PlannerNote(
        id = id,
        title = title,
        description = description,
        userId = userId,
        workflowState = workflowState,
        courseId = courseId,
        todoDate = Instant.parse(todoDate),
        linkedObjectType = linkedObjectType,
        linkedObjectId = linkedObjectId,
        linkedObjectHtmlUrl = linkedObjectHtmlUrl
    )
}
