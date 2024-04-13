package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsSubmissionStatisticsEntity(
    // The number of students who have taken the quiz.
    @SerialName("unique_count")
    val uniqueCount: Int,
    // The mean of the student submission scores.
    @SerialName("score_average")
    val scoreAverage: Double,
    // The highest submission score.
    @SerialName("score_high")
    val scoreHigh: Double,
    // The lowest submission score.
    @SerialName("score_low")
    val scoreLow: Double,
    // Standard deviation of the submission scores.
    @SerialName("score_stdev")
    val scoreStdev: Double,
    // A percentile distribution of student scores
    @SerialName("scores")
    val scores: Map<String, Int>,
    // The mean of the number of questions answered correctly by each student.
    @SerialName("correct_count_average")
    val correctCountAverage: Double,
    // The mean of the number of questions answered incorrectly by each student.
    @SerialName("incorrect_count_average")
    val incorrectCountAverage: Double,
    // The average time spent by students while taking the quiz.
    @SerialName("duration_average")
    val durationAverage: Double,
)
