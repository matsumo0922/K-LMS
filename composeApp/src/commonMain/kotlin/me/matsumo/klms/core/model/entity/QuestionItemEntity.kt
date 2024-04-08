package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class QuestionItemEntity(
    // The question title
    @SerialName("title")
    val title: String,

    // The question content (rich content)
    @SerialName("item_body")
    val itemBody: String,

    // Type of calculator ('none', basic', 'scientific')
    @SerialName("calculator_type")
    val calculatorType: String,

    // Feedback for the question.
    @SerialName("feedback")
    val feedback: QuestionFeedback? = null,

    // Question type slug
    @SerialName("interaction_type_slug")
    val interactionTypeSlug: String,

    // Object containing question data
    @SerialName("interaction_data")
    val interactionData: Any? = null, // Placeholder

    // Additional properties for some question types
    @SerialName("properties")
    val properties: Any? = null, // Placeholder

    // How to score the question
    @SerialName("scoring_data")
    val scoringData: Any? = null, // Placeholder

    // Feedback provided for each answer choice
    @SerialName("answer_feedback")
    val answerFeedback: Map<String, String>?,

    // Algorithm used to score the question
    @SerialName("scoring_algorithm")
    val scoringAlgorithm: String
)
