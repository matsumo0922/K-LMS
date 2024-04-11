package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
        submissionTime = Instant.parse(submissionTime),
        rootAccountId = rootAccountId
    )
}
