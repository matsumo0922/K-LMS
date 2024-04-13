package me.matsumo.klms.core.model.lms

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
    val createdAt: String,
    val updatedAt: String,
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
        createdAt = createdAt,
        updatedAt = updatedAt,
        webvttContent = webvttContent,
    )
}
