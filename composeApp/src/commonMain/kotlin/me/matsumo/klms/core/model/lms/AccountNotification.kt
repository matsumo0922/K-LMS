package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountNotificationEntity

@Serializable
data class AccountNotification(
    val subject: String,
    val message: String,
    val startAt: String,
    val endAt: String,
    val icon: String,
    val roles: List<String>,
    val roleIds: List<Int>,
)

fun AccountNotificationEntity.translate(): AccountNotification {
    return AccountNotification(
        subject = subject,
        message = message,
        startAt = startAt,
        endAt = endAt,
        icon = icon,
        roles = roles,
        roleIds = roleIds,
    )
}
