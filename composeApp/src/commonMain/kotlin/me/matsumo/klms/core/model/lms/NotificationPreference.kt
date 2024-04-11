package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationPreference(
    val href: String,

    val notification: String,

    val category: String,

    val frequency: String
)

fun NotificationPreferenceEntity.translate(): NotificationPreference {
    return NotificationPreference(
        href = href,
        notification = notification,
        category = category
    )
}
