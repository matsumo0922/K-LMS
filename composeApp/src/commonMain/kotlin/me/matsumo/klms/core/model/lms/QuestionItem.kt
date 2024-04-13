package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuestionItemEntity

@Serializable
data class QuestionItem(
    val title: String,
    val itemBody: String,
    val calculatorType: String,
    val feedback: QuestionFeedback? = null,
    val interactionTypeSlug: String,
    val interactionData: String? = null,
    val scoringData: String? = null,
    val answerFeedback: Map<String, String>?,
    val scoringAlgorithm: String,
)

fun QuestionItemEntity.translate(): QuestionItem {
    return QuestionItem(
        title = title,
        itemBody = itemBody,
        calculatorType = calculatorType,
        feedback = feedback?.translate(),
        interactionTypeSlug = interactionTypeSlug,
        interactionData = interactionData,
        scoringData = scoringData,
        answerFeedback = answerFeedback,
        scoringAlgorithm = scoringAlgorithm,
    )
}
