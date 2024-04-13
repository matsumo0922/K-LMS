package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizStatisticsAnswerStatisticsEntity

@Serializable
data class QuizStatisticsAnswerStatistics(
    val id: Int,
    val text: String,
    val weight: Int,
    val responses: Int,
)

fun QuizStatisticsAnswerStatisticsEntity.translate(): QuizStatisticsAnswerStatistics {
    return QuizStatisticsAnswerStatistics(
        id = id,
        text = text,
        weight = weight,
        responses = responses,
    )
}
