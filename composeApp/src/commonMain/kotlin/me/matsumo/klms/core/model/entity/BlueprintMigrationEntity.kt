package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents a blueprint migration which tracks the process of syncing content from a blueprint template to associated courses.
@Serializable
data class BlueprintMigrationEntity(
    // The ID of the migration.
    @SerialName("id") val id: Int,
    // The ID of the template the migration belongs to.
    @SerialName("template_id") val templateId: Int,
    // The ID of the associated course's blueprint subscription.
    @SerialName("subscription_id") val subscriptionId: Int,
    // The ID of the user who queued the migration.
    @SerialName("user_id") val userId: Int,
    // Current state of the content migration
    @SerialName("workflow_state") val workflowState: String,
    // Time when the migration was queued
    @SerialName("created_at") val createdAt: String,
    // Time when the exports begun
    @SerialName("exports_started_at") val exportsStartedAt: String,
    // Time when the exports were completed and imports were queued
    @SerialName("imports_queued_at") val importsQueuedAt: String,
    // Time when the imports were completed
    @SerialName("imports_completed_at") val importsCompletedAt: String,
    // User-specified comment describing changes made in this operation
    @SerialName("comment") val comment: String
)
