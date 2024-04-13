package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NotificationPreferenceEntity(
    @SerialName("href")
    val href: String,
    @SerialName("notification")
    val notification: String,
    @SerialName("category")
    val category: String,
    @SerialName("frequency")
    val frequency: String,
)
