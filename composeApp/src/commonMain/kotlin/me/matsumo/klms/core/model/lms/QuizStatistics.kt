package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizStatisticsEntity

@Serializable
data class QuizStatistics(
    val id: Int,
    val quizId: Int?,
    val multipleAttemptsExist: Boolean,
    val includesAllVersions: Boolean,
    val generatedAt: String,
    val url: String,
    val htmlUrl: String,
    val questionStatistics: List<QuizStatisticsQuestionStatistics>?,
    val submissionStatistics: QuizStatisticsSubmissionStatistics?,
    val links: QuizStatisticsLinks?,
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
        questionStatistics = questionStatistics?.map { it.translate() },
        submissionStatistics = submissionStatistics?.translate(),
        links = links?.translate(),
    )
}
