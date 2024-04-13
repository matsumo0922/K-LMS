package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RubricRatingEntity(
    // Points associated with the rubric rating
    @SerialName("points") val points: Int,
    // Identifier for the rubric rating
    @SerialName("id") val id: String,
    // Brief description of the rubric rating
    @SerialName("description") val description: String,
    // Detailed description of the rubric rating
    @SerialName("long_description") val longDescription: String,
)
