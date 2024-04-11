package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LockInfo(
        val assetString: String,
        val unlockAt: String?,
        val lockAt: String?,
        val contextModule: String?,
    val manuallyLocked: Boolean
)

fun LockInfoEntity.translate(): LockInfo {
    return LockInfo(
        assetString = assetString,
        unlockAt = unlockAt,
        lockAt = lockAt,
        contextModule = contextModule
    )
}
