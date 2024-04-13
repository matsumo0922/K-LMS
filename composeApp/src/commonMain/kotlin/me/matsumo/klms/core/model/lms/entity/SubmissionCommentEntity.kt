package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionCommentEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("author_id")
    val authorId: Int,
    @SerialName("author_name")
    val authorName: String,
    // Placeholder for the 'author' object
    @SerialName("author")
    val author: me.matsumo.klms.core.model.lms.entity.UserEntity?,
    @SerialName("comment")
    val comment: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("edited_at")
    val editedAt: String?,
    @SerialName("media_comment")
    val mediaComment: me.matsumo.klms.core.model.lms.entity.MediaCommentEntity?, // Placeholder - if applicable
)
