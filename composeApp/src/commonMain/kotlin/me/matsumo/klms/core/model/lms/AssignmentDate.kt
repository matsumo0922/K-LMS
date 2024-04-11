package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssignmentDateEntity

@Serializable
data class AssignmentDate(
        val id: Int?,
        val base: Boolean?,
        val title: String,
        val dueAt: String,
        val unlockAt: String,
        val lockAt: String
)

fun AssignmentDateEntity.translate(): AssignmentDate {
    return AssignmentDate(
        id = id,
        base = base,
        title = title,
        dueAt = dueAt,
        unlockAt = unlockAt,
        lockAt = lockAt
    )
}
