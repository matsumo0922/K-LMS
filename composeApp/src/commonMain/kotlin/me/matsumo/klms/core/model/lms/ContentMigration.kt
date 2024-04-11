package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentMigration(
        val id: Int,

        val migrationType: String,

        val migrationTypeTitle: String,

        val migrationIssuesUrl: String,

        val attachment: String?, 
        val progressUrl: String,

        val userId: Int,

        val workflowState: String,

        val startedAt: String,

        val finishedAt: String,

        val preAttachment: String?
)

fun ContentMigrationEntity.translate(): ContentMigration {
    return ContentMigration(
        id = id,
        migrationType = migrationType,
        migrationTypeTitle = migrationTypeTitle,
        migrationIssuesUrl = migrationIssuesUrl,
        attachment = attachment,
        progressUrl = progressUrl,
        userId = userId,
        workflowState = workflowState,
        startedAt = startedAt,
        finishedAt = finishedAt
    )
}
