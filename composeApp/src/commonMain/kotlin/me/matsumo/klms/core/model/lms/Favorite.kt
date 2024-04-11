package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
        val contextId: Int,

        val contextType: String
)

fun FavoriteEntity.translate(): Favorite {
    return Favorite(
        contextId = contextId
    )
}
