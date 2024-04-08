package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountReport(
    // The unique identifier for the report.
    @SerialName("id") val id: Int,
    // The type of report.
    @SerialName("report") val report: String,
    // The url to the report download.
    @SerialName("file_url") val fileUrl: String,
    // The attachment api object of the report. Only available after the report has completed.
    @SerialName("attachment") val attachment: String?,
    // The status of the report
    @SerialName("status") val status: String,
    // The date and time the report was created.
    @SerialName("created_at") val createdAt: String,
    // The date and time the report started processing.
    @SerialName("started_at") val startedAt: String,
    // The date and time the report finished processing.
    @SerialName("ended_at") val endedAt: String,
    // The report parameters
    @SerialName("parameters") val parameters: Parameters,
    // The progress of the report
    @SerialName("progress") val progress: Int,
    // This is the current line count being written to the report. It updates every 1000 records.
    @SerialName("current_line") val currentLine: Int
) {
    @Serializable
    data class Parameters(
        @SerialName("course_id") val courseId: Int,
        @SerialName("start_at") val startAt: String,
        @SerialName("end_at") val endAt: String
    )
}
