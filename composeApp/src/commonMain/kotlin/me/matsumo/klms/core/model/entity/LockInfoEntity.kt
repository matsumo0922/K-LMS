package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LockInfoEntity(
    // Asset string for the object causing the lock
    @SerialName("asset_string") val assetString: String,
    // (Optional) Time at which this was/will be unlocked. Must be before the due date.
    @SerialName("unlock_at") val unlockAt: String?,
    // (Optional) Time at which this was/will be locked. Must be after the due date.
    @SerialName("lock_at") val lockAt: String?,
    // (Optional) Context module causing the lock.
    @SerialName("context_module") val contextModule: String?,
    @SerialName("manually_locked") val manuallyLocked: Boolean
)
