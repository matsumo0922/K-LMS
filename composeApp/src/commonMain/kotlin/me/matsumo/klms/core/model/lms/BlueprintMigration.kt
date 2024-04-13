package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintMigrationEntity

@Serializable
data class BlueprintMigration(
    val id: Int,
    val templateId: Int,
    val subscriptionId: Int,
    val userId: Int,
    val workflowState: String,
    val createdAt: String,
    val exportsStartedAt: String,
    val importsQueuedAt: String,
    val importsCompletedAt: String,
    val comment: String,
)

fun BlueprintMigrationEntity.translate(): BlueprintMigration {
    return BlueprintMigration(
        id = id,
        templateId = templateId,
        subscriptionId = subscriptionId,
        userId = userId,
        workflowState = workflowState,
        createdAt = createdAt,
        exportsStartedAt = exportsStartedAt,
        importsQueuedAt = importsQueuedAt,
        importsCompletedAt = importsCompletedAt,
        comment = comment,
    )
}
