package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizReportEntity

@Serializable
data class QuizReport(
    val id: Int,
    val quizId: Int,
    val reportType: String,
    val readableType: String,
    val includesAllVersions: Boolean,
    val anonymous: Boolean,
    val generatable: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val url: String,
    val file: LmsFile?,
    val progressUrl: String?,
    val progress: LmsProgress?,
)

fun QuizReportEntity.translate(): QuizReport {
    return QuizReport(
        id = id,
        quizId = quizId,
        reportType = reportType,
        readableType = readableType,
        includesAllVersions = includesAllVersions,
        anonymous = anonymous,
        generatable = generatable,
        createdAt = createdAt,
        updatedAt = updatedAt,
        url = url,
        file = file?.translate(),
        progressUrl = progressUrl,
        progress = progress?.translate(),
    )
}
