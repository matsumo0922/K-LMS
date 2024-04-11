package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeResultEntity(
    // A unique identifier for this result
    @SerialName("id")
    val id: Int,

    // The student's score
    @SerialName("score")
    val score: Double, // Using 'Double' for potential decimals

    // When submitted or assessed
    @SerialName("submitted_or_assessed_at")
    val submittedOrAssessedAt: String,

    // Unique identifiers of associated objects
    @SerialName("links")
    val links: me.matsumo.klms.core.model.lms.entity.OutcomeResultEntity.OutcomeResultLinks,

    // Score's percent of maximum points possible
    @SerialName("percent")
    val percent: Double
) {

    @Serializable
    data class OutcomeResultLinks(
        @SerialName("user")
        val user: String,

        @SerialName("learning_outcome")
        val learningOutcome: String,

        @SerialName("alignment")
        val alignment: String
    )
}
