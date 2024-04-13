package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FavoriteEntity(
    // The ID of the object the Favorite refers to
    @SerialName("context_id")
    val contextId: Int,
    // The type of the object the Favorite refers to ...
    @SerialName("context_type")
    val contextType: String,
)
