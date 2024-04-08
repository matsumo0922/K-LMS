package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class ContentDetailsEntity(
    @SerialName("points_possible")
    val pointsPossible: Int,

    @SerialName("due_at")
    val dueAt: String,

    @SerialName("unlock_at")
    val unlockAt: String,

    @SerialName("lock_at")
    val lockAt: String,

    @SerialName("locked_for_user")
    val lockedForUser: Boolean,

    @SerialName("lock_explanation")
    val lockExplanation: String,

    @SerialName("lock_info")
    val lockInfo: LockInfo
) {

    @kotlinx.serialization.Serializable
    data class LockInfo(
        @SerialName("asset_string")
        val assetString: String,

        @SerialName("unlock_at")
        val unlockAt: String,

        @SerialName("lock_at")
        val lockAt: String,

        @SerialName("context_module")
        val contextModule: ContextModule
    )

    @Serializable
    data class ContextModule(
        // Add fields for your 'ContextModule' if needed
    )

}
