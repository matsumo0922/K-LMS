package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AvatarEntity

@Serializable
data class Avatar(
    val type: String,
    val url: String,
    val token: String,
    val displayName: String,
    val id: Int?,
    val contentType: String?,
    val filename: String?,
    val size: Int?,
)

fun AvatarEntity.translate(): Avatar {
    return Avatar(
        type = type,
        url = url,
        token = token,
        displayName = displayName,
        id = id,
        contentType = contentType,
        filename = filename,
        size = size,
    )
}
