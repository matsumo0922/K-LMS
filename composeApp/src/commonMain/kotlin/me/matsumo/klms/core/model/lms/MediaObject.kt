package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MediaObjectEntity

@Serializable
data class MediaObject(
        val canAddCaptions: Boolean,

    val userEnteredTitle: String,

    val title: String,

    val mediaId: String,

    val mediaType: String,

        val mediaTracks: List<MediaTrack>,

        val mediaSources: List<MediaSource>
) {
    @Serializable
    data class MediaTrack(
                val kind: String,

        val createdAt: String,

        val updatedAt: String,

        val url: String,

                val id: Int,

                val locale: String
    )

    @Serializable
    data class MediaSource(
                val height: Int,

                val width: Int,

                val contentType: String,

                val containerFormat: String,

                val url: String,

                val bitrate: String,

                val size: String,

                val isOriginal: String,

                val fileExt: String
    )
}

fun MediaObjectEntity.translate(): MediaObject {
    return MediaObject(
        canAddCaptions = canAddCaptions,
        userEnteredTitle = userEnteredTitle,
        title = title,
        mediaId = mediaId,
        mediaType = mediaType,
        mediaTracks = mediaTracks,
        kind = kind,
        createdAt = createdAt,
        updatedAt = updatedAt,
        url = url,
        id = id,
        height = height,
        width = width,
        contentType = contentType,
        containerFormat = containerFormat,
        url = url,
        bitrate = bitrate,
        size = size,
        isOriginal = isOriginal
    )
}
