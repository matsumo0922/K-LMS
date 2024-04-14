package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PageEntity

@Serializable
data class LmsPage(
    val pageId: Int,
    val url: String,
    val title: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val hideFromStudents: Boolean,
    val editingRoles: String,
    val lastEditedBy: LmsUser?,
    val body: String?,
    val published: Boolean,
    val publishAt: Instant?,
    val frontPage: Boolean,
    val lockedForUser: Boolean,
    val lockInfo: LockInfo?,
    val lockExplanation: String?,
)

fun PageEntity.translate(): LmsPage {
    return LmsPage(
        pageId = pageId,
        url = url,
        title = title,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        hideFromStudents = hideFromStudents,
        editingRoles = editingRoles,
        lastEditedBy = lastEditedBy?.translate(),
        body = body,
        published = published,
        publishAt = publishAt?.let { Instant.parse(it) },
        frontPage = frontPage,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo?.translate(),
        lockExplanation = lockExplanation,
    )
}
