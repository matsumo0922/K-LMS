package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnnouncementEntity(
    // The ID of the announcement
    @SerialName("id") val id: Int,
    // The title of the announcement
    @SerialName("title") val title: String,
    // The message content of the announcement
    @SerialName("message") val message: String,
    // When the announcement was posted
    @SerialName("posted_at") val postedAt: String,
    // When the announcement is scheduled to be posted (if delayed)
    @SerialName("delayed_post_at") val delayedPostAt: String?,
    // The context (e.g., course or group) the announcement is associated with
    @SerialName("context_code") val contextCode: String,
)
