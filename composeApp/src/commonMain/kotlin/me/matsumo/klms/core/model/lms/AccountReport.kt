package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountReportEntity

@Serializable
data class AccountReport(
    val id: Int,
    val report: String,
    val fileUrl: String,
    val attachment: String?,
    val status: String,
    val createdAt: String,
    val startedAt: String,
    val endedAt: String,
    val parameters: Parameters,
    val progress: Int,
    val currentLine: Int,
) {
    @Serializable
    data class Parameters(
        val courseId: Int,
        val startAt: String,
        val endAt: String,
    )
}

fun AccountReportEntity.translate(): AccountReport {
    return AccountReport(
        id = id,
        report = report,
        fileUrl = fileUrl,
        attachment = attachment,
        status = status,
        createdAt = createdAt,
        startedAt = startedAt,
        endedAt = endedAt,
        progress = progress,
        currentLine = currentLine,
        parameters = AccountReport.Parameters(
            courseId = parameters.courseId,
            startAt = parameters.startAt,
            endAt = parameters.endAt,
        ),
    )
}
