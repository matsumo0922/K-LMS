package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OriginalityReportEntity(
    // The id of the OriginalityReport
    @SerialName("id")
    val id: Int,

    // The id of the file receiving the originality score
    @SerialName("file_id")
    val fileId: Int,

    //  The originality score (between 0 and 100)
    @SerialName("originality_score")
    val originalityScore: Double,

    // The ID of the file containing the originality report
    @SerialName("originality_report_file_id")
    val originalityReportFileId: Int?,

    //  A non-LTI launch URL to find the originality report
    @SerialName("originality_report_url")
    val originalityReportUrl: String?,

    // ToolSetting object
    // @SerialName("tool_setting")
    // val toolSetting: ToolSetting?,

    // An error message (if any)
    @SerialName("error_message")
    val errorMessage: String?,

    // The submission time
    @SerialName("submission_time")
    val submissionTime: String?,

    // The ID of the root Account
    @SerialName("root_account_id")
    val rootAccountId: Int,
)
