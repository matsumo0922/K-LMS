package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentDetails(
    val pointsPossible: Int,

    val dueAt: String,

    val unlockAt: String,

    val lockAt: String,

    val lockedForUser: Boolean,

    val lockExplanation: String,

    val lockInfo: LockInfoEntity
)

fun ContentDetailsEntity.translate(): ContentDetails {
    return ContentDetails(
        pointsPossible = pointsPossible,
        dueAt = dueAt,
        unlockAt = unlockAt,
        lockAt = lockAt,
        lockedForUser = lockedForUser,
        lockExplanation = lockExplanation
    )
}
