package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GroupEntity

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
    val users: List<User>? = null,
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
        permissions = permissions?.let {
            Group.Permissions(
                createDiscussionTopic = it.createDiscussionTopic,
                createAnnouncement = it.createAnnouncement,
            )
        },
        users = users?.map { it.translate() },
    )
}
