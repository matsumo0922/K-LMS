package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
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
    val createdAt: Instant,
    val updatedAt: Instant,
    val unlockAt: Instant? = null,
    val locked: Boolean,
    val hidden: Boolean,
    val lockAt: Instant? = null,
    val hiddenForUser: Boolean,
    val visibilityLevel: String?,
    val thumbnailUrl: String? = null,
    val modifiedAt: Instant,
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
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        unlockAt = unlockAt?.let { Instant.parse(it) },
        locked = locked,
        hidden = hidden,
        lockAt = lockAt?.let { Instant.parse(it) },
        hiddenForUser = hiddenForUser,
        visibilityLevel = visibilityLevel,
        thumbnailUrl = thumbnailUrl,
        modifiedAt = Instant.parse(modifiedAt),
        mimeClass = mimeClass,
        mediaEntryId = mediaEntryId,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo,
        lockExplanation = lockExplanation,
        previewUrl = previewUrl,
    )
}
