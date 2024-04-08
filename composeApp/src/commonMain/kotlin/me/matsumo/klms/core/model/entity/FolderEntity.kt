package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FolderEntity(
    @SerialName("context_type")
    val contextType: String,

    @SerialName("context_id")
    val contextId: Int,

    @SerialName("files_count")
    val filesCount: Int,

    @SerialName("position")
    val position: Int,

    @SerialName("updated_at")
    val updatedAt: String,

    @SerialName("folders_url")
    val foldersUrl: String,

    @SerialName("files_url")
    val filesUrl: String,

    @SerialName("full_name")
    val fullName: String,

    @SerialName("lock_at")
    val lockAt: String,

    @SerialName("id")
    val id: Int,

    @SerialName("folders_count")
    val foldersCount: Int,

    @SerialName("name")
    val name: String,

    @SerialName("parent_folder_id")
    val parentFolderId: Int,

    @SerialName("created_at")
    val createdAt: String,

    @SerialName("unlock_at")
    val unlockAt: String? = null,

    @SerialName("hidden")
    val hidden: Boolean,

    @SerialName("hidden_for_user")
    val hiddenForUser: Boolean,

    @SerialName("locked")
    val locked: Boolean,

    @SerialName("locked_for_user")
    val lockedForUser: Boolean,

    @SerialName("for_submissions")
    val forSubmissions: Boolean
)
