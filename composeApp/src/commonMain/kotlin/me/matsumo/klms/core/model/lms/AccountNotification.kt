package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountNotificationEntity

@Serializable
data class AccountNotification(
    val subject: String,
    val message: String,
    val startAt: Instant,
    val endAt: Instant,
    val icon: String,
    val roles: List<String>,
    val roleIds: List<Int>,
)

fun AccountNotificationEntity.translate(): AccountNotification {
    return AccountNotification(
        subject = subject,
        message = message,
        startAt = Instant.parse(startAt),
        endAt = Instant.parse(endAt),
        icon = icon,
        roles = roles,
        roleIds = roleIds,
    )
}
