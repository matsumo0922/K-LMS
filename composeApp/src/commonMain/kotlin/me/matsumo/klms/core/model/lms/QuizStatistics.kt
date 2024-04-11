package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatistics(
        val id: Int,

        val quizId: Int?,

        val multipleAttemptsExist: Boolean,

        val includesAllVersions: Boolean,

        val generatedAt: String,

        val url: String,

        val htmlUrl: String,

        val questionStatistics: List<QuizStatisticsQuestionStatisticsEntity>?,

        val submissionStatistics: QuizStatisticsSubmissionStatisticsEntity?,

        val links: QuizStatisticsLinksEntity?
)

fun QuizStatisticsEntity.translate(): QuizStatistics {
    return QuizStatistics(
        id = id,
        quizId = quizId,
        multipleAttemptsExist = multipleAttemptsExist,
        includesAllVersions = includesAllVersions,
        generatedAt = generatedAt,
        url = url,
        htmlUrl = htmlUrl,
        questionStatistics = questionStatistics,
        submissionStatistics = submissionStatistics
    )
}
