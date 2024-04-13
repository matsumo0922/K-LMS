package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LockInfoEntity

@Serializable
data class LockInfo(
    val assetString: String,
    val unlockAt: String?,
    val lockAt: String?,
    val contextModule: String?,
    val manuallyLocked: Boolean,
)

fun LockInfoEntity.translate(): LockInfo {
    return LockInfo(
        assetString = assetString,
        unlockAt = unlockAt,
        lockAt = lockAt,
        contextModule = contextModule,
        manuallyLocked = manuallyLocked,
    )
}
