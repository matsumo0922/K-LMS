package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

        val file: FileEntity?,  
        val progressUrl: String?,

        val progress: ProgressEntity?  )

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
        file = file,
        progressUrl = progressUrl
    )
}
