package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageRevision(
        val revisionId: Int,

        val updatedAt: String,

        val latest: Boolean,

        val editedBy: UserEntity?, 
        val url: String?,

    val title: String?,

    val body: String?
)

fun PageRevisionEntity.translate(): PageRevision {
    return PageRevision(
        revisionId = revisionId,
        updatedAt = updatedAt,
        latest = latest,
        editedBy = editedBy,
        url = url,
        title = title
    )
}
