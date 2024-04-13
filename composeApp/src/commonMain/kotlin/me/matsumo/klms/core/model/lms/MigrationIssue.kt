package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MigrationIssueEntity

@Serializable
data class MigrationIssue(
    val id: Int,
    val contentMigrationUrl: String,
    val description: String,
    val workflowState: String,
    val fixIssueHtmlUrl: String,
    val issueType: String,
    val errorReportHtmlUrl: String? = null,
    val errorMessage: String? = null,
    val createdAt: String,
    val updatedAt: String,
)

fun MigrationIssueEntity.translate(): MigrationIssue {
    return MigrationIssue(
        id = id,
        contentMigrationUrl = contentMigrationUrl,
        description = description,
        workflowState = workflowState,
        fixIssueHtmlUrl = fixIssueHtmlUrl,
        issueType = issueType,
        errorReportHtmlUrl = errorReportHtmlUrl,
        errorMessage = errorMessage,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}
