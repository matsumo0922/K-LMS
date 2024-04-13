package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideEntity

@Serializable
data class QuizAssignmentOverride(
    val id: Int?,
    val dueAt: String,
    val unlockAt: String?,
    val lockAt: String?,
    val title: String?,
    val base: Boolean?,
)

fun QuizAssignmentOverrideEntity.translate(): QuizAssignmentOverride {
    return QuizAssignmentOverride(
        id = id,
        dueAt = dueAt,
        unlockAt = unlockAt,
        lockAt = lockAt,
        title = title,
        base = base,
    )
}
