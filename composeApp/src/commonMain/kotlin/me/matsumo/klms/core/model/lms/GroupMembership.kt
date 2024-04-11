package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupMembership(
        val id: Int,

        val groupId: Int,

        val userId: Int,

        val workflowState: String,

        val moderator: Boolean,

        val justCreated: Boolean? = null,

        val sisImportId: Int? = null
)

fun GroupMembershipEntity.translate(): GroupMembership {
    return GroupMembership(
        id = id,
        groupId = groupId,
        userId = userId,
        workflowState = workflowState,
        moderator = moderator,
        justCreated = justCreated
    )
}
