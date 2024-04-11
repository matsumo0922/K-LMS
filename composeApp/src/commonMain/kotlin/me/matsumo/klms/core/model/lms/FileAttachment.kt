package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileAttachment(
    @SerialName("content-type")
    val contentType: String,

    val url: String,

    val filename: String,

    val displayName: String
)

fun FileAttachmentEntity.translate(): FileAttachment {
    return FileAttachment(
        contentType = contentType,
        url = url,
        filename = filename
    )
}
