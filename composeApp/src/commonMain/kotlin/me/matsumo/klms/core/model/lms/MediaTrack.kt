package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MediaTrackEntity

@Serializable
data class MediaTrack(
    val id: Int,
    val userId: Int,
    val mediaObjectId: Int,
    val kind: String,
    val locale: String,
    val content: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val webvttContent: String,
)

fun MediaTrackEntity.translate(): MediaTrack {
    return MediaTrack(
        id = id,
        userId = userId,
        mediaObjectId = mediaObjectId,
        kind = kind,
        locale = locale,
        content = content,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        webvttContent = webvttContent,
    )
}
