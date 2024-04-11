package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class File(
    val id: Int,

    val uuid: String,

    val folderId: Int,

    val displayName: String,

    val filename: String,

    @SerialName("content-type")
    val contentType: String,

    val url: String,

    val size: Int,

    val createdAt: String,

    val updatedAt: String,

    val unlockAt: String? = null,

    val locked: Boolean,

    val hidden: Boolean,

    val lockAt: String? = null,

    val hiddenForUser: Boolean,

    val visibilityLevel: String?,

    val thumbnailUrl: String? = null,

    val modifiedAt: String,

    val mimeClass: String,

    val mediaEntryId: String?,

    val lockedForUser: Boolean,

    val lockInfo: LockInfoEntity? = null, 
    val lockExplanation: String? = null,

    val previewUrl: String? = null
)

fun FileEntity.translate(): File {
    return File(
        id = id,
        uuid = uuid,
        folderId = folderId,
        displayName = displayName,
        filename = filename,
        contentType = contentType,
        url = url,
        size = size,
        createdAt = createdAt,
        updatedAt = updatedAt,
        unlockAt = unlockAt,
        locked = locked,
        hidden = hidden,
        lockAt = lockAt,
        hiddenForUser = hiddenForUser,
        visibilityLevel = visibilityLevel,
        thumbnailUrl = thumbnailUrl,
        modifiedAt = modifiedAt,
        mimeClass = mimeClass,
        mediaEntryId = mediaEntryId,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo,
        lockExplanation = lockExplanation
    )
}
