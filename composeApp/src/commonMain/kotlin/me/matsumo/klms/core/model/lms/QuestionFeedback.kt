package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuestionFeedbackEntity

@Serializable
data class QuestionFeedback(
    val neutral: String,
    val correct: String,
    val incorrect: String,
)

fun QuestionFeedbackEntity.translate(): QuestionFeedback {
    return QuestionFeedback(
        neutral = neutral,
        correct = correct,
        incorrect = incorrect,
    )
}
