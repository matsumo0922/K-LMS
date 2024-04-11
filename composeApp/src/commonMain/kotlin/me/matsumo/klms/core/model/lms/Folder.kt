package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Folder(
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

    val forSubmissions: Boolean
)

fun FolderEntity.translate(): Folder {
    return Folder(
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
        lockedForUser = lockedForUser
    )
}
