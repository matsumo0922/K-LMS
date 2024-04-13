package me.matsumo.klms.core.model.lms

import io.github.alexzhirkevich.cupertino.CupertinoSwitchDefaults.height
import io.ktor.client.utils.EmptyContent.contentType
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
    val mediaSources: List<MediaSource>,
) {
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
        val fileExt: String,
    )
}

fun MediaObjectEntity.translate(): MediaObject {
    return MediaObject(
        canAddCaptions = canAddCaptions,
        userEnteredTitle = userEnteredTitle,
        title = title,
        mediaId = mediaId,
        mediaType = mediaType,
        mediaTracks = mediaTracks.map { it.translate() },
        mediaSources = mediaSources.map {
            MediaObject.MediaSource(
                height = it.height,
                width = it.width,
                contentType = it.contentType,
                containerFormat = it.containerFormat,
                url = it.url,
                bitrate = it.bitrate,
                size = it.size,
                isOriginal = it.isOriginal,
                fileExt = it.fileExt,
            )
        },
    )
}
