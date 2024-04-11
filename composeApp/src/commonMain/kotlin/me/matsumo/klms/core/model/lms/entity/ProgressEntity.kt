package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProgressEntity(
    // the ID of the Progress object
    @SerialName("id")
    val id: Int,

    // the context owning the job.
    @SerialName("context_id")
    val contextId: Int,

    @SerialName("context_type")
    val contextType: String,

    // the id of the user who started the job
    @SerialName("user_id")
    val userId: Int,

    // the type of operation
    @SerialName("tag")
    val tag: String,

    // percent completed
    @SerialName("completion")
    val completion: Int,

    // the state of the job ...
    @SerialName("workflow_state")
    val workflowState: String,

    // the time the job was created
    @SerialName("created_at")
    val createdAt: String,

    // the time the job was last updated
    @SerialName("updated_at")
    val updatedAt: String,

    // optional details about the job
    @SerialName("message")
    val message: String? = null,

    // optional results of the job. ...
    @SerialName("results")
    val results: me.matsumo.klms.core.model.lms.entity.ResultEntity? = null, // Placeholder type - need more structure

    // url where a progress update can be retrieved
    @SerialName("url")
    val url: String,
)
