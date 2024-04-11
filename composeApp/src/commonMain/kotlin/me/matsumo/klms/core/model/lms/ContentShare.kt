package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentShare(
        val id: Int,

        val name: String,

        val contentType: String,

        val createdAt: String,

        val updatedAt: String,

        val userId: Int,

        val sender: UserEntity? = null,

        val receivers: List<UserEntity> = emptyList(),

        val sourceCourse: SourceCourse,

        val readState: String,

        val contentExport: ContentExport
) {
    @Serializable
    data class User(
        val id: Int,
        val displayName: String,
        val avatarImageUrl: String,
        val htmlUrl: String
    )

    @Serializable
    data class SourceCourse(
        val id: Int,
        val name: String
    )

    @Serializable
    data class ContentExport(
        val id: Int
    )
}

fun ContentShareEntity.translate(): ContentShare {
    return ContentShare(
        id = id,
        name = name,
        contentType = contentType,
        createdAt = createdAt,
        updatedAt = updatedAt,
        userId = userId,
        sender = sender,
        receivers = receivers,
        sourceCourse = sourceCourse,
        readState = readState,
        id = id,
        displayName = displayName,
        avatarImageUrl = avatarImageUrl,
        id = id
    )
}
