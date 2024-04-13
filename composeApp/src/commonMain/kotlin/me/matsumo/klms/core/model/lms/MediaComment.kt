package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MediaCommentEntity

@Serializable
data class MediaComment(
    val contentType: String,
    val displayName: String,
    val mediaId: String,
    val mediaType: String,
    val url: String,
)

fun MediaCommentEntity.translate(): MediaComment {
    return MediaComment(
        contentType = contentType,
        displayName = displayName,
        mediaId = mediaId,
        mediaType = mediaType,
        url = url,
    )
}
