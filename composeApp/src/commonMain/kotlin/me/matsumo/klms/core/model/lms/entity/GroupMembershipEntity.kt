package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupMembershipEntity(
    // The id of the membership object
    @SerialName("id")
    val id: Int,

    // The id of the group object to which the membership belongs
    @SerialName("group_id")
    val groupId: Int,

    // The id of the user object to which the membership belongs
    @SerialName("user_id")
    val userId: Int,

    // The current state of the membership. ...
    @SerialName("workflow_state")
    val workflowState: String,

    // Whether or not the user is a moderator of the group ...
    @SerialName("moderator")
    val moderator: Boolean,

    // optional: whether or not the record was just created ...
    @SerialName("just_created")
    val justCreated: Boolean? = null,

    // The id of the SIS import if created through SIS. ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null
)
