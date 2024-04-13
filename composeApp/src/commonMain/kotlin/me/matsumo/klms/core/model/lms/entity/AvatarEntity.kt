package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvatarEntity(
    // The type of the avatar
    @SerialName("type")
    val type: String,
    // The URL of the avatar image
    @SerialName("url")
    val url: String,
    // A unique representation of the avatar
    @SerialName("token")
    val token: String,
    // A textual description of the avatar record.
    @SerialName("display_name")
    val displayName: String,
    // Attachment ID (if type is 'attachment')
    @SerialName("id")
    val id: Int?,
    // Content-Type of the attachment  (if type is 'attachment')
    @SerialName("content-type")
    val contentType: String?,
    // Filename of the attachment (if type is 'attachment')
    @SerialName("filename")
    val filename: String?,
    // Size of the attachment in bytes (if type is 'attachment')
    @SerialName("size")
    val size: Int?,
)
