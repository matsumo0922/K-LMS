package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FileEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("uuid")
    val uuid: String,
    @SerialName("folder_id")
    val folderId: Int,
    @SerialName("display_name")
    val displayName: String,
    @SerialName("filename")
    val filename: String,
    @SerialName("content-type")
    val contentType: String,
    @SerialName("url")
    val url: String,
    @SerialName("size")
    val size: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("unlock_at")
    val unlockAt: String? = null,
    @SerialName("locked")
    val locked: Boolean,
    @SerialName("hidden")
    val hidden: Boolean,
    @SerialName("lock_at")
    val lockAt: String? = null,
    @SerialName("hidden_for_user")
    val hiddenForUser: Boolean,
    @SerialName("visibility_level")
    val visibilityLevel: String?,
    @SerialName("thumbnail_url")
    val thumbnailUrl: String? = null,
    @SerialName("modified_at")
    val modifiedAt: String,
    @SerialName("mime_class")
    val mimeClass: String,
    @SerialName("media_entry_id")
    val mediaEntryId: String?,
    @SerialName("locked_for_user")
    val lockedForUser: Boolean,
    @SerialName("lock_info")
    val lockInfo: me.matsumo.klms.core.model.lms.entity.LockInfoEntity? = null, // Placeholder type for 'lock_info' if needed

    @SerialName("lock_explanation")
    val lockExplanation: String? = null,
    @SerialName("preview_url")
    val previewUrl: String? = null,
)
