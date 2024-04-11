package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AnnouncementEntity

@Serializable
data class Announcement(
        val id: Int,
        val title: String,
        val message: String,
        val postedAt: String,
        val delayedPostAt: String?,
        val contextCode: String
)

fun AnnouncementEntity.translate(): Announcement {
    return Announcement(
        id = id,
        title = title,
        message = message,
        postedAt = postedAt,
        delayedPostAt = delayedPostAt,
        contextCode = contextCode
    )
}
