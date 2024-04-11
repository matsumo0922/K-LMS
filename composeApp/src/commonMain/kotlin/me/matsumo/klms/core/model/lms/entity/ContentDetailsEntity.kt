package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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
    val lockInfo: me.matsumo.klms.core.model.lms.entity.LockInfoEntity
)
