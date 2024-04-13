package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.FileEntity
import me.matsumo.klms.core.model.lms.entity.LockInfoEntity

@Serializable
data class LmsFile(
    val id: Int,
    val uuid: String,
    val folderId: Int,
    val displayName: String,
    val filename: String,
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
    val previewUrl: String? = null,
)

fun FileEntity.translate(): LmsFile {
    return LmsFile(
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
        lockExplanation = lockExplanation,
        previewUrl = previewUrl,
    )
}
