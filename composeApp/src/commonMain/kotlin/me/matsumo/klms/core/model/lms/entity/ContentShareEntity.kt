package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentShareEntity(
    // The id of the content share for the current user
    @SerialName("id")
    val id: Int,

    // The name of the shared content
    @SerialName("name")
    val name: String,

    // The type of content that was shared.
    @SerialName("content_type")
    val contentType: String,

    // The datetime the content was shared with this user.
    @SerialName("created_at")
    val createdAt: String,

    // The datetime the content was updated.
    @SerialName("updated_at")
    val updatedAt: String,

    // The id of the user who sent or received the content share.
    @SerialName("user_id")
    val userId: Int,

    // The user who shared the content. ...
    @SerialName("sender")
    val sender: me.matsumo.klms.core.model.lms.entity.UserEntity? = null,

    // An Array of users the content is shared with. ...
    @SerialName("receivers")
    val receivers: List<me.matsumo.klms.core.model.lms.entity.UserEntity> = emptyList(),

    // The course the content was originally shared from.
    @SerialName("source_course")
    val sourceCourse: me.matsumo.klms.core.model.lms.entity.ContentShareEntity.SourceCourse,

    // Whether the recipient has viewed the content share.
    @SerialName("read_state")
    val readState: String,

    // The content export record associated with this content share
    @SerialName("content_export")
    val contentExport: me.matsumo.klms.core.model.lms.entity.ContentShareEntity.ContentExport
) {
    @Serializable
    data class User(
        @SerialName("id")
        val id: Int,
        @SerialName("display_name")
        val displayName: String,
        @SerialName("avatar_image_url")
        val avatarImageUrl: String,
        @SerialName("html_url")
        val htmlUrl: String
    )

    @Serializable
    data class SourceCourse(
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String
    )

    @Serializable
    data class ContentExport(
        @SerialName("id")
        val id: Int
    )
}
