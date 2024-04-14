package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentMigrationEntity

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
    val startedAt: Instant,
    val finishedAt: Instant,
    val preAttachment: String?,
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
        startedAt = Instant.parse(startedAt),
        finishedAt = Instant.parse(finishedAt),
        preAttachment = preAttachment,
    )
}
