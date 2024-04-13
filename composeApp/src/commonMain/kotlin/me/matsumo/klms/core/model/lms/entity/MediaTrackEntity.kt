package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaTrackEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("user_id")
    val userId: Int,
    @SerialName("media_object_id")
    val mediaObjectId: Int,
    @SerialName("kind")
    val kind: String, // Type of track: captions or subtitles

    @SerialName("locale")
    val locale: String,
    @SerialName("content")
    val content: String, // Content in VTT format

    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("webvtt_content")
    val webvttContent: String,
)
