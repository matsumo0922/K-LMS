package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizSubmissionQuestionEntity

@Serializable
data class QuizSubmissionQuestion(
    val id: Int,
    val flagged: Boolean,
    val answer: QuizeAnswer?,
    val answers: List<QuizeAnswer>,
)

fun QuizSubmissionQuestionEntity.translate(): QuizSubmissionQuestion {
    return QuizSubmissionQuestion(
        id = id,
        flagged = flagged,
        answer = answer?.translate(),
        answers = answers?.map { it.translate() } ?: emptyList(),
    )
}
