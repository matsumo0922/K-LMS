package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentDetailsEntity

@Serializable
data class ContentDetails(
    val pointsPossible: Int,
    val dueAt: String,
    val unlockAt: String,
    val lockAt: String,
    val lockedForUser: Boolean,
    val lockExplanation: String,
    val lockInfo: LockInfo,
)

fun ContentDetailsEntity.translate(): ContentDetails {
    return ContentDetails(
        pointsPossible = pointsPossible,
        dueAt = dueAt,
        unlockAt = unlockAt,
        lockAt = lockAt,
        lockedForUser = lockedForUser,
        lockExplanation = lockExplanation,
        lockInfo = lockInfo.translate(),
    )
}
