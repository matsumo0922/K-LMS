package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CommunicationChannelEntity

@Serializable
data class CommunicationChannel(
        val id: Int,

        val address: String,

        val type: String,

        val position: Int,

        val userId: Int,

        val bounceCount: Int,

        val lastBounceAt: String,

        val workflowState: String
)

fun CommunicationChannelEntity.translate(): CommunicationChannel {
    return CommunicationChannel(
        id = id,
        address = address,
        type = type,
        position = position,
        userId = userId,
        bounceCount = bounceCount,
        lastBounceAt = lastBounceAt,
        workflowState = workflowState
    )
}
