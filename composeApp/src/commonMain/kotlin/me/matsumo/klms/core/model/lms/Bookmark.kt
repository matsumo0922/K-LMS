package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BookmarkEntity

@Serializable
data class Bookmark(
        val id: Int,
        val name: String,
        val url: String,
        val position: Int,
        val data: Map<String, Int>
)

fun BookmarkEntity.translate(): Bookmark {
    return Bookmark(
        id = id,
        name = name,
        url = url,
        position = position,
        data = data
    )
}
