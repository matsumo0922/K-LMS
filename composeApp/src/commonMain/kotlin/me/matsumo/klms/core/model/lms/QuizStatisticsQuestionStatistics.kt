package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsQuestionStatistics(
        val responses: Int,

        val answers: List<QuizStatisticsAnswerStatisticsEntity>?
)

fun QuizStatisticsQuestionStatisticsEntity.translate(): QuizStatisticsQuestionStatistics {
    return QuizStatisticsQuestionStatistics(
        responses = responses
    )
}
