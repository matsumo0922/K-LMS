package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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
    val feedback: me.matsumo.klms.core.model.lms.entity.QuestionFeedbackEntity? = null,
    // Question type slug
    @SerialName("interaction_type_slug")
    val interactionTypeSlug: String,
    // Object containing question data
    @SerialName("interaction_data")
    val interactionData: String? = null, // Placeholder

    // How to score the question
    @SerialName("scoring_data")
    val scoringData: String? = null, // Placeholder

    // Feedback provided for each answer choice
    @SerialName("answer_feedback")
    val answerFeedback: Map<String, String>?,
    // Algorithm used to score the question
    @SerialName("scoring_algorithm")
    val scoringAlgorithm: String,
) : me.matsumo.klms.core.model.lms.entity.EntryEntity
