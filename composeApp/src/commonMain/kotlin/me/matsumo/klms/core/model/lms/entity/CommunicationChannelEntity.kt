package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommunicationChannelEntity(
    // The ID of the communication channel.
    @SerialName("id")
    val id: Int,
    // The address, or path, of the communication channel.
    @SerialName("address")
    val address: String,
    // The type of communication channel being described ...
    @SerialName("type")
    val type: String,
    // The position of this communication channel ...
    @SerialName("position")
    val position: Int,
    // The ID of the user that owns this communication channel.
    @SerialName("user_id")
    val userId: Int,
    // The number of bounces the channel has experienced ...
    @SerialName("bounce_count")
    val bounceCount: Int,
    // The time the last bounce occurred.
    @SerialName("last_bounce_at")
    val lastBounceAt: String,
    // The current state of the communication channel ...
    @SerialName("workflow_state")
    val workflowState: String,
)
