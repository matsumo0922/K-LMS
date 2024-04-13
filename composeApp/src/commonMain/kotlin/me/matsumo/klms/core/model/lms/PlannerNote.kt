package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PlannerNoteEntity

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
    val linkedObjectUrl: String,
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
        linkedObjectHtmlUrl = linkedObjectHtmlUrl,
        linkedObjectUrl = linkedObjectUrl,
    )
}
