package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaCommentEntity(
    @SerialName("content-type")
    val contentType: String,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("media_id")
    val mediaId: String,
    @SerialName("media_type")
    val mediaType: String,
    @SerialName("url")
    val url: String,
)
