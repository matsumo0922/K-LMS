package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Group(
        val id: Int,

        val name: String,

        val description: String? = null,

        val isPublic: Boolean,

        val followedByUser: Boolean,

        val joinLevel: String,

        val membersCount: Int,

        val avatarUrl: String,

        val contextType: String,

    val courseId: Int,

        val role: String? = null,

        val groupCategoryId: Int,

        val sisGroupId: String? = null,

        val sisImportId: Int? = null,

        val storageQuotaMb: Int,

        val permissions: Permissions? = null,

        val users: List<UserEntity>? = null
) {
    @Serializable
    data class Permissions(
        val createDiscussionTopic: Boolean,

                val createAnnouncement: Boolean,
    )
}


fun GroupEntity.translate(): Group {
    return Group(
        id = id,
        name = name,
        description = description,
        isPublic = isPublic,
        followedByUser = followedByUser,
        joinLevel = joinLevel,
        membersCount = membersCount,
        avatarUrl = avatarUrl,
        contextType = contextType,
        courseId = courseId,
        role = role,
        groupCategoryId = groupCategoryId,
        sisGroupId = sisGroupId,
        sisImportId = sisImportId,
        storageQuotaMb = storageQuotaMb,
        permissions = permissions,
        createDiscussionTopic = createDiscussionTopic,
        createAnnouncement = createAnnouncement
    )
}
