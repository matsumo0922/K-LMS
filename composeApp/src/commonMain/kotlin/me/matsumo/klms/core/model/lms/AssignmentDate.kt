package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssignmentDateEntity

@Serializable
data class AssignmentDate(
    val id: Int?,
    val base: Boolean?,
    val title: String,
    val dueAt: Instant,
    val unlockAt: Instant,
    val lockAt: Instant,
)

fun AssignmentDateEntity.translate(): AssignmentDate {
    return AssignmentDate(
        id = id,
        base = base,
        title = title,
        dueAt = Instant.parse(dueAt),
        unlockAt = Instant.parse(unlockAt),
        lockAt = Instant.parse(lockAt),
    )
}
