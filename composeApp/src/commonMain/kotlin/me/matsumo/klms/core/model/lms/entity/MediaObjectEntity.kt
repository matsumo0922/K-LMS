package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaObjectEntity(
    // whether or not the current user can upload media_tracks ...
    @SerialName("can_add_captions")
    val canAddCaptions: Boolean,
    @SerialName("user_entered_title")
    val userEnteredTitle: String,
    @SerialName("title")
    val title: String,
    @SerialName("media_id")
    val mediaId: String,
    @SerialName("media_type")
    val mediaType: String,
    // an array of all the media_tracks uploaded to this Media Object
    @SerialName("media_tracks")
    val mediaTracks: List<MediaTrackEntity>,
    // an array of all the transcoded files ...
    @SerialName("media_sources")
    val mediaSources: List<MediaSource>,
) {
    @Serializable
    data class MediaSource(
        // height of the video flavor in pixels
        @SerialName("height")
        val height: Int,
        // width of the video flavor in pixels
        @SerialName("width")
        val width: Int,
        // Content-type of the video flavor
        @SerialName("content_type")
        val contentType: String,
        // File container format (isom, flash video, etc.)
        @SerialName("containerFormat")
        val containerFormat: String,
        // url of the video flavor
        @SerialName("url")
        val url: String,
        // avg bitrate of the video flavor (in kbps)
        @SerialName("bitrate")
        val bitrate: String,
        // size of the video flavor (in Kb)
        @SerialName("size")
        val size: String,
        // if 'true', this source is the original video file
        @SerialName("isOriginal")
        val isOriginal: String,
        // File Extension
        @SerialName("fileExt")
        val fileExt: String,
    )
}
