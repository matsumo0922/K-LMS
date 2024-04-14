package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentDetailsEntity

@Serializable
data class ContentDetails(
    val pointsPossible: Int,
    val dueAt: Instant,
    val unlockAt: Instant,
    val lockAt: Instant,
    val lockedForUser: Boolean,
    val lockExplanation: String,
    val lockInfo: LockInfo,
)

fun ContentDetailsEntity.translate(): ContentDetails {
    return ContentDetails(
        pointsPossible = pointsPossible,
        dueAt = Instant.parse(dueAt),
        unlockAt = Instant.parse(unlockAt),
        lockAt = Instant.parse(lockAt),
        lockedForUser = lockedForUser,
        lockExplanation = lockExplanation,
        lockInfo = lockInfo.translate(),
    )
}
