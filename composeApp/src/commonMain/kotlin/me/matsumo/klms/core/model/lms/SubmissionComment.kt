package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.SubmissionCommentEntity

@Serializable
data class SubmissionComment(
    val id: Int,
    val authorId: Int,
    val authorName: String,
    val author: LmsUser?,
    val comment: String,
    val createdAt: Instant,
    val editedAt: Instant?,
    val mediaComment: MediaComment?,
)

fun SubmissionCommentEntity.translate(): SubmissionComment {
    return SubmissionComment(
        id = id,
        authorId = authorId,
        authorName = authorName,
        author = author?.translate(),
        comment = comment,
        createdAt = Instant.parse(createdAt),
        editedAt = editedAt?.let { Instant.parse(it) },
        mediaComment = mediaComment?.translate(),
    )
}
