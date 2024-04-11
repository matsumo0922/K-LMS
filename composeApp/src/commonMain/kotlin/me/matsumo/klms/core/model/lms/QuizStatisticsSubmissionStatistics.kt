package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsSubmissionStatistics(
        val uniqueCount: Int,

        val scoreAverage: Double,

        val scoreHigh: Double,

        val scoreLow: Double,

        val scoreStdev: Double,

        val scores: Map<String, Int>,

        val correctCountAverage: Double,

        val incorrectCountAverage: Double,

        val durationAverage: Double
)

fun QuizStatisticsSubmissionStatisticsEntity.translate(): QuizStatisticsSubmissionStatistics {
    return QuizStatisticsSubmissionStatistics(
        uniqueCount = uniqueCount,
        scoreAverage = scoreAverage,
        scoreHigh = scoreHigh,
        scoreLow = scoreLow,
        scoreStdev = scoreStdev,
        scores = scores,
        correctCountAverage = correctCountAverage,
        incorrectCountAverage = incorrectCountAverage
    )
}
