package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionComment(
    val id: Int,

    val authorId: Int,

    val authorName: String,

        val author: UserEntity?,

    val comment: String,

    val createdAt: String,

    val editedAt: String?,

    val mediaComment: MediaCommentEntity? )

fun SubmissionCommentEntity.translate(): SubmissionComment {
    return SubmissionComment(
        id = id,
        authorId = authorId,
        authorName = authorName,
        author = author,
        comment = comment,
        createdAt = createdAt,
        editedAt = editedAt
    )
}
