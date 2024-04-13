package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizQuestionEntity

@Serializable
data class QuizQuestion(
    val id: Int,
    val quizId: Int,
    val position: Int,
    val questionName: String,
    val questionType: String,
    val questionText: String,
    val pointsPossible: Int,
    val correctComments: String,
    val incorrectComments: String,
    val neutralComments: String,
    val answers: List<QuizeAnswer>?,
)

fun QuizQuestionEntity.translate(): QuizQuestion {
    return QuizQuestion(
        id = id,
        quizId = quizId,
        position = position,
        questionName = questionName,
        questionType = questionType,
        questionText = questionText,
        pointsPossible = pointsPossible,
        correctComments = correctComments,
        incorrectComments = incorrectComments,
        neutralComments = neutralComments,
        answers = answers?.map { it.translate() },
    )
}
