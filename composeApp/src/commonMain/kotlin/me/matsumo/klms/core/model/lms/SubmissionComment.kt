package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.SubmissionCommentEntity

@Serializable
data class SubmissionComment(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val author: User?,
    val comment: String,
    val createdAt: String,
    val editedAt: String?,
    val mediaComment: MediaComment?,
)

fun SubmissionCommentEntity.translate(): SubmissionComment {
    return SubmissionComment(
        id = id,
        authorId = authorId,
        authorName = authorName,
        author = author?.translate(),
        comment = comment,
        createdAt = createdAt,
        editedAt = editedAt,
        mediaComment = mediaComment?.translate(),
    )
}
