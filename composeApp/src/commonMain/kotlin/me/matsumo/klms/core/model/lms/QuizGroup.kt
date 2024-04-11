package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizGroup(
        val id: Int,

        val quizId: Int,

        val name: String,

        val pickCount: Int,

        val questionPoints: Int,

        val assessmentQuestionBankId: Int,

        val position: Int
)

fun QuizGroupEntity.translate(): QuizGroup {
    return QuizGroup(
        id = id,
        quizId = quizId,
        name = name,
        pickCount = pickCount,
        questionPoints = questionPoints,
        assessmentQuestionBankId = assessmentQuestionBankId
    )
}
