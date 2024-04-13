package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizStatisticsQuestionStatisticsEntity

@Serializable
data class QuizStatisticsQuestionStatistics(
    val responses: Int,
    val answers: List<QuizStatisticsAnswerStatistics>,
)

fun QuizStatisticsQuestionStatisticsEntity.translate(): QuizStatisticsQuestionStatistics {
    return QuizStatisticsQuestionStatistics(
        responses = responses,
        answers = answers?.map { it.translate() } ?: emptyList(),
    )
}
