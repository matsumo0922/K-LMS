package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.FolderEntity

@Serializable
data class LmsFolder(
    val contextType: String,
    val contextId: Int,
    val filesCount: Int,
    val position: Int,
    val updatedAt: Instant,
    val foldersUrl: String,
    val filesUrl: String,
    val fullName: String,
    val lockAt: Instant,
    val id: Int,
    val foldersCount: Int,
    val name: String,
    val parentFolderId: Int,
    val createdAt: Instant,
    val unlockAt: Instant? = null,
    val hidden: Boolean,
    val hiddenForUser: Boolean,
    val locked: Boolean,
    val lockedForUser: Boolean,
    val forSubmissions: Boolean,
)

fun FolderEntity.translate(): LmsFolder {
    return LmsFolder(
        contextType = contextType,
        contextId = contextId,
        filesCount = filesCount,
        position = position,
        updatedAt = Instant.parse(updatedAt),
        foldersUrl = foldersUrl,
        filesUrl = filesUrl,
        fullName = fullName,
        lockAt = Instant.parse(lockAt),
        id = id,
        foldersCount = foldersCount,
        name = name,
        parentFolderId = parentFolderId,
        createdAt = Instant.parse(createdAt),
        unlockAt = unlockAt?.let { Instant.parse(it) },
        hidden = hidden,
        hiddenForUser = hiddenForUser,
        locked = locked,
        lockedForUser = lockedForUser,
        forSubmissions = forSubmissions,
    )
}
