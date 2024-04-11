package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupEntity(
    // The ID of the group.
    @SerialName("id")
    val id: Int,

    // The display name of the group.
    @SerialName("name")
    val name: String,

    // A description of the group. ...
    @SerialName("description")
    val description: String? = null,

    // Whether or not the group is public. ...
    @SerialName("is_public")
    val isPublic: Boolean,

    // Whether or not the current user is following this group.
    @SerialName("followed_by_user")
    val followedByUser: Boolean,

    // How people are allowed to join the group. ...
    @SerialName("join_level")
    val joinLevel: String,

    // The number of members currently in the group
    @SerialName("members_count")
    val membersCount: Int,

    // The url of the group's avatar
    @SerialName("avatar_url")
    val avatarUrl: String,

    // The course or account that the group belongs to. ...
    @SerialName("context_type")
    val contextType: String,

    @SerialName("course_id")
    val courseId: Int,

    // Certain types of groups have special role designations. ...
    @SerialName("role")
    val role: String? = null,

    // The ID of the group's category.
    @SerialName("group_category_id")
    val groupCategoryId: Int,

    // The SIS ID of the group. ...
    @SerialName("sis_group_id")
    val sisGroupId: String? = null,

    // The id of the SIS import ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null,

    // the storage quota for the group, in megabytes
    @SerialName("storage_quota_mb")
    val storageQuotaMb: Int,

    // optional: the permissions the user has for the group. ...
    @SerialName("permissions")
    val permissions: me.matsumo.klms.core.model.lms.entity.GroupEntity.Permissions? = null,

    // optional: A list of users that are members in the group. ...
    @SerialName("users")
    val users: List<me.matsumo.klms.core.model.lms.entity.UserEntity>? = null
) {
    @Serializable
    data class Permissions(
        @SerialName("create_discussion_topic")
        val createDiscussionTopic: Boolean,

        // optional: the permissions the user has for the group. ...
        @SerialName("create_announcement")
        val createAnnouncement: Boolean,
    )
}

// You'll likely need 'Permissions' and 'User' data classes defined as well
