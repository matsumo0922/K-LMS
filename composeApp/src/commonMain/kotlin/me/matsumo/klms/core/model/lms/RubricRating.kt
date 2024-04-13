package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.RubricRatingEntity

@Serializable
data class RubricRating(
    val points: Int,
    val id: String,
    val description: String,
    val longDescription: String,
)

fun RubricRatingEntity.translate(): RubricRating {
    return RubricRating(
        points = points,
        id = id,
        description = description,
        longDescription = longDescription,
    )
}
