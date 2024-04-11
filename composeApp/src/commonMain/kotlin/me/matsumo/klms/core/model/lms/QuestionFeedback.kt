package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionFeedback(
    val neutral: String,

    val correct: String,

    val incorrect: String
)

fun QuestionFeedbackEntity.translate(): QuestionFeedback {
    return QuestionFeedback(
        neutral = neutral,
        correct = correct
    )
}
