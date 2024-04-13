package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollaborationEntity(
    // The unique identifier for the collaboration
    @SerialName("id")
    val id: Int,
    // A name for the type of collaboration
    @SerialName("collaboration_type")
    val collaborationType: String,
    // The collaboration document identifier for the collaboration provider
    @SerialName("document_id")
    val documentId: String,
    // The canvas id of the user who created the collaboration
    @SerialName("user_id")
    val userId: Int,
    // The canvas id of the course or group to which the collaboration belongs
    @SerialName("context_id")
    val contextId: Int,
    // The canvas type of the course or group to which the collaboration belongs
    @SerialName("context_type")
    val contextType: String,
    // The LTI launch url to view collaboration.
    @SerialName("url")
    val url: String? = null,
    // The timestamp when the collaboration was created
    @SerialName("created_at")
    val createdAt: String,
    // The timestamp when the collaboration was last modified
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("title")
    val title: String? = null,
    // Another representation of the collaboration type
    @SerialName("type")
    val type: String,
    // The LTI launch url to edit the collaboration
    @SerialName("update_url")
    val updateUrl: String? = null,
    // The name of the user who owns the collaboration
    @SerialName("user_name")
    val userName: String,
)
