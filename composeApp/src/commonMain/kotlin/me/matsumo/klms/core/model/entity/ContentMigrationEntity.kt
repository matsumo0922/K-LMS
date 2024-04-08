package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentMigrationEntity(
    // the unique identifier for the migration
    @SerialName("id")
    val id: Int,

    // the type of content migration
    @SerialName("migration_type")
    val migrationType: String,

    // the name of the content migration type
    @SerialName("migration_type_title")
    val migrationTypeTitle: String,

    // API url to the content migration's issues
    @SerialName("migration_issues_url")
    val migrationIssuesUrl: String,

    // attachment api object for the uploaded file ...
    @SerialName("attachment")
    val attachment: String?, // Placeholder - you might need a further data class to represent this

    // The api endpoint for polling the current progress
    @SerialName("progress_url")
    val progressUrl: String,

    // The user who started the migration
    @SerialName("user_id")
    val userId: Int,

    // Current state of the content migration
    @SerialName("workflow_state")
    val workflowState: String,

    // timestamp
    @SerialName("started_at")
    val startedAt: String,

    // timestamp
    @SerialName("finished_at")
    val finishedAt: String,

    // file uploading data ...
    @SerialName("pre_attachment")
    val preAttachment: PreAttachment  // You'll need a data class to represent this
) {
    @Serializable
    data class PreAttachment(
        @SerialName("upload_url")
        val uploadUrl: String,

        @SerialName("message")
        val message: String,

        @SerialName("upload_params")
        val uploadParams: Map<String, Any> // Placeholder type: You'll need to refine this
    )
}
