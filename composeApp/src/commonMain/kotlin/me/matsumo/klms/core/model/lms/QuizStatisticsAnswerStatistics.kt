package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsAnswerStatistics(
        val id: Int,

        val text: String,

        val weight: Int,

        val responses: Int
)

fun QuizStatisticsAnswerStatisticsEntity.translate(): QuizStatisticsAnswerStatistics {
    return QuizStatisticsAnswerStatistics(
        id = id,
        text = text,
        weight = weight
    )
}
