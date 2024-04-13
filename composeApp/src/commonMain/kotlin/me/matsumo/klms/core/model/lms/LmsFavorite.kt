package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.FavoriteEntity

@Serializable
data class LmsFavorite(
    val contextId: Int,
    val contextType: String,
)

fun FavoriteEntity.translate(): LmsFavorite {
    return LmsFavorite(
        contextId = contextId,
        contextType = contextType,
    )
}
