package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizGroupEntity

@Serializable
data class QuizGroup(
    val id: Int,
    val quizId: Int,
    val name: String,
    val pickCount: Int,
    val questionPoints: Int,
    val assessmentQuestionBankId: Int,
    val position: Int,
)

fun QuizGroupEntity.translate(): QuizGroup {
    return QuizGroup(
        id = id,
        quizId = quizId,
        name = name,
        pickCount = pickCount,
        questionPoints = questionPoints,
        assessmentQuestionBankId = assessmentQuestionBankId,
        position = position,
    )
}
