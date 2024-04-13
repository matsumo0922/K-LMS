package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OriginalityReportEntity

@Serializable
data class OriginalityReport(
    val id: Int,
    val fileId: Int,
    val originalityScore: Double,
    val originalityReportFileId: Int?,
    val originalityReportUrl: String?,
    val errorMessage: String?,
    val submissionTime: Instant?,
    val rootAccountId: Int,
)

fun OriginalityReportEntity.translate(): OriginalityReport {
    return OriginalityReport(
        id = id,
        fileId = fileId,
        originalityScore = originalityScore,
        originalityReportFileId = originalityReportFileId,
        originalityReportUrl = originalityReportUrl,
        errorMessage = errorMessage,
        submissionTime = submissionTime?.let { Instant.parse(it) },
        rootAccountId = rootAccountId,
    )
}
