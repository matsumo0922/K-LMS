package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupCategoryEntity(
    // The ID of the group category.
    @SerialName("id")
    val id: Int,

    // The display name of the group category.
    @SerialName("name")
    val name: String,

    // Certain types of group categories have special role designations. ...
    @SerialName("role")
    val role: String? = null,

    // If the group category allows users to join a group ...
    @SerialName("self_signup")
    val selfSignup: String? = null,

    // Gives instructors the ability to automatically have group leaders ...
    @SerialName("auto_leader")
    val autoLeader: String? = null,

    // The course or account that the category group belongs to. ...
    @SerialName("context_type")
    val contextType: String,

    @SerialName("account_id")
    val accountId: Int,

    // If self-signup is enabled, group_limit can be set to cap ...
    @SerialName("group_limit")
    val groupLimit: Int? = null,

    // The SIS identifier for the group category. ...
    @SerialName("sis_group_category_id")
    val sisGroupCategoryId: String? = null,

    // The unique identifier for the SIS import. ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null,

    // If the group category has not yet finished ...
    @SerialName("progress")
    val progress: me.matsumo.klms.core.model.lms.entity.ProgressEntity? = null
)
