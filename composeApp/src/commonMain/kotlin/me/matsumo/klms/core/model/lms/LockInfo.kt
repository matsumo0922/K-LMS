package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LockInfoEntity

@Serializable
data class LockInfo(
    val assetString: String,
    val unlockAt: Instant?,
    val lockAt: Instant?,
    val contextModule: String?,
    val manuallyLocked: Boolean,
)

fun LockInfoEntity.translate(): LockInfo {
    return LockInfo(
        assetString = assetString,
        unlockAt = unlockAt?.let { Instant.parse(it) },
        lockAt = lockAt?.let { Instant.parse(it) },
        contextModule = contextModule,
        manuallyLocked = manuallyLocked,
    )
}
