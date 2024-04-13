package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.FolderEntity

@Serializable
data class LmsFolder(
    val contextType: String,
    val contextId: Int,
    val filesCount: Int,
    val position: Int,
    val updatedAt: String,
    val foldersUrl: String,
    val filesUrl: String,
    val fullName: String,
    val lockAt: String,
    val id: Int,
    val foldersCount: Int,
    val name: String,
    val parentFolderId: Int,
    val createdAt: String,
    val unlockAt: String? = null,
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
        updatedAt = updatedAt,
        foldersUrl = foldersUrl,
        filesUrl = filesUrl,
        fullName = fullName,
        lockAt = lockAt,
        id = id,
        foldersCount = foldersCount,
        name = name,
        parentFolderId = parentFolderId,
        createdAt = createdAt,
        unlockAt = unlockAt,
        hidden = hidden,
        hiddenForUser = hiddenForUser,
        locked = locked,
        lockedForUser = lockedForUser,
        forSubmissions = forSubmissions,
    )
}
