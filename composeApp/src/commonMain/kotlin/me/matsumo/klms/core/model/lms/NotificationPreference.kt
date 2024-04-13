package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.NotificationPreferenceEntity

@Serializable
data class NotificationPreference(
    val href: String,
    val notification: String,
    val category: String,
    val frequency: String,
)

fun NotificationPreferenceEntity.translate(): NotificationPreference {
    return NotificationPreference(
        href = href,
        notification = notification,
        category = category,
        frequency = frequency,
    )
}
