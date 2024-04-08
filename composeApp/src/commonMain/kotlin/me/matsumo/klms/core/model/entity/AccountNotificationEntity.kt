package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountNotificationEntity(
    // The subject of the notifications
    @SerialName("subject") val subject: String,
    // The message to be sent in the notification.
    @SerialName("message") val message: String,
    // When to send out the notification.
    @SerialName("start_at") val startAt: String,
    // When to expire the notification.
    @SerialName("end_at") val endAt: String,
    // The icon to display with the message.  Defaults to warning.
    @SerialName("icon") val icon: String,
    // (Deprecated) The roles to send the notification to.  If roles is not passed it defaults to all roles
    @SerialName("roles") val roles: List<String>,
    // The roles to send the notification to.  If roles is not passed it defaults to all roles
    @SerialName("role_ids") val roleIds: List<Int>
)
