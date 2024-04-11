package me.matsumo.klms.core.model.entity

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.EntryEntity

@Serializable
data class QuestionItem(
        val title: String,

        val itemBody: String,

        val calculatorType: String,

        val feedback: QuestionFeedbackEntity? = null,

        val interactionTypeSlug: String,

        val interactionData: String? = null, 
        val scoringData: String? = null, 
        val answerFeedback: Map<String, String>?,

        val scoringAlgorithm: String
) : EntryEntity

fun QuestionItemEntity.translate(): QuestionItem {
    return QuestionItem(
        title = title,
        itemBody = itemBody,
        calculatorType = calculatorType,
        feedback = feedback,
        interactionTypeSlug = interactionTypeSlug,
        interactionData = interactionData,
        scoringData = scoringData,
        answerFeedback = answerFeedback
    )
}
