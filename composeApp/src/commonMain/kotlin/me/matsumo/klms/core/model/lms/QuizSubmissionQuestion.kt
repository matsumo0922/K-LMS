package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSubmissionQuestion(
        val id: Int,

        val flagged: Boolean,

        val answer: AnswerEntity?, 
        val answers: List<AnswerEntity>? )

fun QuizSubmissionQuestionEntity.translate(): QuizSubmissionQuestion {
    return QuizSubmissionQuestion(
        id = id,
        flagged = flagged,
        answer = answer
    )
}
