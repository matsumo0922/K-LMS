package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
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
    val createdAt: Instant,
    val updatedAt: Instant,
    val deletedAt: Instant?,
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
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        deletedAt = deletedAt?.let { Instant.parse(it) },
    )
}
