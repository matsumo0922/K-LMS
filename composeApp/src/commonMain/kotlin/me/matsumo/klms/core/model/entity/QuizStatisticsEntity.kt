package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsEntity(
    // The ID of the quiz statistics report.
    @SerialName("id")
    val id: Int,

    // The ID of the Quiz
    @SerialName("quiz_id")
    val quizId: Int?,

    // Whether there are multiple submission attempts
    @SerialName("multiple_attempts_exist")
    val multipleAttemptsExist: Boolean,

    // Whether stats include all submission versions
    @SerialName("includes_all_versions")
    val includesAllVersions: Boolean,

    // Time the statistics were generated
    @SerialName("generated_at")
    val generatedAt: String,

    // The API URL to these quiz statistics.
    @SerialName("url")
    val url: String,

    // HTML URL to view the statistics
    @SerialName("html_url")
    val htmlUrl: String,

    // Question-specific statistics
    @SerialName("question_statistics")
    val questionStatistics: List<QuizStatisticsQuestionStatisticsEntity>?,

    //  Submission-specific statistics
    @SerialName("submission_statistics")
    val submissionStatistics: QuizStatisticsSubmissionStatisticsEntity?,

    // Links to related media (JSON-API format)
    @SerialName("links")
    val links: QuizStatisticsLinksEntity?
)
