package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PageRevisionEntity

@Serializable
data class PageRevision(
    val revisionId: Int,
    val updatedAt: String,
    val latest: Boolean,
    val editedBy: User?,
    val url: String?,
    val title: String?,
    val body: String?,
)

fun PageRevisionEntity.translate(): PageRevision {
    return PageRevision(
        revisionId = revisionId,
        updatedAt = updatedAt,
        latest = latest,
        editedBy = editedBy?.translate(),
        url = url,
        title = title,
        body = body,
    )
}
