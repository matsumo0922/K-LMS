package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AnnouncementEntity

@Serializable
data class Announcement(
    val id: Int,
    val title: String,
    val message: String,
    val postedAt: Instant,
    val delayedPostAt: Instant?,
    val contextCode: String,
)

fun AnnouncementEntity.translate(): Announcement {
    return Announcement(
        id = id,
        title = title,
        message = message,
        postedAt = Instant.parse(postedAt),
        delayedPostAt = delayedPostAt?.let { Instant.parse(it) },
        contextCode = contextCode,
    )
}
