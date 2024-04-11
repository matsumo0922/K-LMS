package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileAttachmentEntity(
    @SerialName("content-type")
    val contentType: String,

    @SerialName("url")
    val url: String,

    @SerialName("filename")
    val filename: String,

    @SerialName("display_name")
    val displayName: String
)
