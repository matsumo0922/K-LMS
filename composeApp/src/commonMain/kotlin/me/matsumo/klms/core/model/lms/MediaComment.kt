package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaComment(
    @SerialName("content-type")
    val contentType: String,

    val displayName: String,

    val mediaId: String,

    val mediaType: String,

    val url: String
)

fun MediaCommentEntity.translate(): MediaComment {
    return MediaComment(
        contentType = contentType,
        displayName = displayName,
        mediaId = mediaId,
        mediaType = mediaType
    )
}
