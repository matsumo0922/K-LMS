package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintMigrationEntity

@Serializable
data class BlueprintMigration(
    val id: Int,
    val templateId: Int,
    val subscriptionId: Int,
    val userId: Int,
    val workflowState: String,
    val createdAt: Instant,
    val exportsStartedAt: Instant,
    val importsQueuedAt: Instant,
    val importsCompletedAt: Instant,
    val comment: String,
)

fun BlueprintMigrationEntity.translate(): BlueprintMigration {
    return BlueprintMigration(
        id = id,
        templateId = templateId,
        subscriptionId = subscriptionId,
        userId = userId,
        workflowState = workflowState,
        createdAt = Instant.parse(createdAt),
        exportsStartedAt = Instant.parse(exportsStartedAt),
        importsQueuedAt = Instant.parse(importsQueuedAt),
        importsCompletedAt = Instant.parse(importsCompletedAt),
        comment = comment,
    )
}
