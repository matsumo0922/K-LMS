package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents a bookmark in a user's navigation, allowing quick access to frequently visited places within the platform.
@Serializable
data class BookmarkEntity(
    // The ID of the bookmark.
    @SerialName("id") val id: Int,
    // The name of the bookmark.
    @SerialName("name") val name: String,
    // The URL the bookmark points to.
    @SerialName("url") val url: String,
    // The position of the bookmark in the user's list.
    @SerialName("position") val position: Int,
    // Additional data associated with the bookmark, such as which tab to open.
    @SerialName("data") val data: Map<String, Int>,
)
