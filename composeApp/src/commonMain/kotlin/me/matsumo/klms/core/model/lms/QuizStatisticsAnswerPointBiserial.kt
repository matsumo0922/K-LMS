package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsAnswerPointBiserial(
        val answerId: Int,

        val pointBiserial: Double,

        val correct: Boolean?,

        val distractor: Boolean?
)

fun QuizStatisticsAnswerPointBiserialEntity.translate(): QuizStatisticsAnswerPointBiserial {
    return QuizStatisticsAnswerPointBiserial(
        answerId = answerId,
        pointBiserial = pointBiserial,
        correct = correct
    )
}
