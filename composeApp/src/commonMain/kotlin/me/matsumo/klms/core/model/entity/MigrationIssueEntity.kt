package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MigrationIssueEntity(
    // the unique identifier for the issue
    @SerialName("id")
    val id: Int,

    // API url to the content migration
    @SerialName("content_migration_url")
    val contentMigrationUrl: String,

    // Description of the issue for the end-user
    @SerialName("description")
    val description: String,

    // Current state of the issue: active, resolved
    @SerialName("workflow_state")
    val workflowState: String,

    // HTML Url to the Canvas page to investigate the issue
    @SerialName("fix_issue_html_url")
    val fixIssueHtmlUrl: String,

    // Severity of the issue: todo, warning, error
    @SerialName("issue_type")
    val issueType: String,

    // Link to a Canvas error report if present ...
    @SerialName("error_report_html_url")
    val errorReportHtmlUrl: String? = null,

    // Site administrator error message ...
    @SerialName("error_message")
    val errorMessage: String? = null,

    // timestamp
    @SerialName("created_at")
    val createdAt: String,

    // timestamp
    @SerialName("updated_at")
    val updatedAt: String
)
