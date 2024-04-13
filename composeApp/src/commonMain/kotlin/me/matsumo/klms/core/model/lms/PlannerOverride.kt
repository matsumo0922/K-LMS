package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PlannerOverrideEntity

@Serializable
data class PlannerOverride(
    val id: Int,
    val plannableType: String,
    val plannableId: Int,
    val userId: Int,
    val assignmentId: Int?,
    val workflowState: String,
    val markedComplete: Boolean,
    val dismissed: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
)

fun PlannerOverrideEntity.translate(): PlannerOverride {
    return PlannerOverride(
        id = id,
        plannableType = plannableType,
        plannableId = plannableId,
        userId = userId,
        assignmentId = assignmentId,
        workflowState = workflowState,
        markedComplete = markedComplete,
        dismissed = dismissed,
        createdAt = createdAt,
        updatedAt = updatedAt,
        deletedAt = deletedAt,
    )
}
