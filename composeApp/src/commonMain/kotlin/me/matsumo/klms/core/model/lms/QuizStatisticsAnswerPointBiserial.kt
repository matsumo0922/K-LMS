package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizStatisticsAnswerPointBiserialEntity

@Serializable
data class QuizStatisticsAnswerPointBiserial(
    val answerId: Int,
    val pointBiserial: Double,
    val correct: Boolean?,
    val distractor: Boolean?,
)

fun QuizStatisticsAnswerPointBiserialEntity.translate(): QuizStatisticsAnswerPointBiserial {
    return QuizStatisticsAnswerPointBiserial(
        answerId = answerId,
        pointBiserial = pointBiserial,
        correct = correct,
        distractor = distractor,
    )
}
