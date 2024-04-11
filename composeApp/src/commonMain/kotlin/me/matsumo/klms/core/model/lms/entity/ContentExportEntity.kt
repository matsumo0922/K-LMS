package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentExportEntity(
    // the unique identifier for the export
    @SerialName("id")
    val id: Int,

    // the date and time this export was requested
    @SerialName("created_at")
    val createdAt: String,

    // the type of content migration: 'common_cartridge' or 'qti'
    @SerialName("export_type")
    val exportType: String,

    // attachment api object for the export package ...
    @SerialName("attachment")
    val attachment: me.matsumo.klms.core.model.lms.entity.ContentExportEntity.Attachment,

    // The api endpoint for polling the current progress
    @SerialName("progress_url")
    val progressUrl: String,

    // The ID of the user who started the export
    @SerialName("user_id")
    val userId: Int,

    // Current state of the content migration: created exporting exported failed
    @SerialName("workflow_state")
    val workflowState: String
) {
    @Serializable
    data class Attachment(
        @SerialName("url")
        val url: String
    )
}
