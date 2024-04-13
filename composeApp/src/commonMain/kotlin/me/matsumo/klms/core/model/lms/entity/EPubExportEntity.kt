package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPubExportEntity(
    // the unique identifier for the export
    @SerialName("id")
    val id: Int,
    // the date and time this export was requested
    @SerialName("created_at")
    val createdAt: String,
    // attachment api object for the export ePub (not present until the export completes)
    @SerialName("attachment")
    val attachment: Attachment? = null, // Placeholder type - you may need to define this

    // The api endpoint for polling the current progress
    @SerialName("progress_url")
    val progressUrl: String,
    // The ID of the user who started the export
    @SerialName("user_id")
    val userId: Int,
    // Current state of the ePub export: ...
    @SerialName("workflow_state")
    val workflowState: String,
) {

    @Serializable
    data class Attachment(
        @SerialName("url")
        val url: Int,
    )
}

// You may need a  data class for the 'attachment' object if it has its own structure.
