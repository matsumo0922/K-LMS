package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideEntity

@Serializable
data class QuizAssignmentOverride(
    val id: Int?,
    val dueAt: Instant,
    val unlockAt: Instant?,
    val lockAt: Instant?,
    val title: String?,
    val base: Boolean?,
)

fun QuizAssignmentOverrideEntity.translate(): QuizAssignmentOverride {
    return QuizAssignmentOverride(
        id = id,
        dueAt = Instant.parse(dueAt),
        unlockAt = unlockAt?.let { Instant.parse(it) },
        lockAt = lockAt?.let { Instant.parse(it) },
        title = title,
        base = base,
    )
}
