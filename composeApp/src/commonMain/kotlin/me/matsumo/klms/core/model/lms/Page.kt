package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PageEntity

@Serializable
data class Page(
        val pageId: Int,

        val url: String,

        val title: String,

        val createdAt: String,

        val updatedAt: String,

        val hideFromStudents: Boolean,

        val editingRoles: String,

        val lastEditedBy: UserEntity?, 
        val body: String?,

        val published: Boolean,

        val publishAt: String?,

        val frontPage: Boolean,

        val lockedForUser: Boolean,

        val lockInfo: LockInfoEntity?,

        val lockExplanation: String?
)

fun PageEntity.translate(): Page {
    return Page(
        pageId = pageId,
        url = url,
        title = title,
        createdAt = createdAt,
        updatedAt = updatedAt,
        hideFromStudents = hideFromStudents,
        editingRoles = editingRoles,
        lastEditedBy = lastEditedBy,
        body = body,
        published = published,
        publishAt = publishAt,
        frontPage = frontPage,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo
    )
}
