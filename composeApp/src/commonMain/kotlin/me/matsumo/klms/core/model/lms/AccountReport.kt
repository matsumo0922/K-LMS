package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountReportEntity

@Serializable
data class AccountReport(
    val id: Int,
    val report: String,
    val fileUrl: String,
    val attachment: String?,
    val status: String,
    val createdAt: Instant,
    val startedAt: Instant,
    val endedAt: Instant,
    val parameters: Parameters,
    val progress: Int,
    val currentLine: Int,
) {
    @Serializable
    data class Parameters(
        val courseId: Int,
        val startAt: Instant,
        val endAt: Instant,
    )
}

fun AccountReportEntity.translate(): AccountReport {
    return AccountReport(
        id = id,
        report = report,
        fileUrl = fileUrl,
        attachment = attachment,
        status = status,
        createdAt = Instant.parse(createdAt),
        startedAt = Instant.parse(startedAt),
        endedAt = Instant.parse(endedAt),
        progress = progress,
        currentLine = currentLine,
        parameters = AccountReport.Parameters(
            courseId = parameters.courseId,
            startAt = Instant.parse(parameters.startAt),
            endAt = Instant.parse(parameters.endAt),
        ),
    )
}
