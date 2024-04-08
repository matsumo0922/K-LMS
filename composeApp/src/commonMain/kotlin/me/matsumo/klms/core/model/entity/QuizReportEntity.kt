package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class QuizReportEntity(
    // The ID of the quiz report
    @SerialName("id")
    val id: Int,

    // The ID of the quiz
    @SerialName("quiz_id")
    val quizId: Int,

    // The type of the report
    @SerialName("report_type")
    val reportType: String,

    // Localized version of the report_type
    @SerialName("readable_type")
    val readableType: String,

    // Whether includes all submissions
    @SerialName("includes_all_versions")
    val includesAllVersions: Boolean,

    // Whether the report is anonymous
    @SerialName("anonymous")
    val anonymous: Boolean,

    // Whether the report can be generated
    @SerialName("generatable")
    val generatable: Boolean,

    // Date/Time the report was created
    @SerialName("created_at")
    val createdAt: String,

    // Date/Time the report was last updated
    @SerialName("updated_at")
    val updatedAt: String,

    // The API endpoint for this report
    @SerialName("url")
    val url: String,

    // File object if the report has finished generating
    @SerialName("file")
    val file: File?,  // Placeholder

    // URL for retrieving progress if not yet generated
    @SerialName("progress_url")
    val progressUrl: String?,

    // Progress object if being generated
    @SerialName("progress")
    val progress: Progress?  // Placeholder
)
