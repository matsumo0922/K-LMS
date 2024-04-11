package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RubricRating(
        val points: Int,
        val id: String,
        val description: String,
        val longDescription: String
)

fun RubricRatingEntity.translate(): RubricRating {
    return RubricRating(
        points = points,
        id = id,
        description = description
    )
}
