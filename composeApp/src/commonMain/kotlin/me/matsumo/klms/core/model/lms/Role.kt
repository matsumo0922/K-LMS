package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Role(
        val id: Int,

        val label: String,

        val roleAlias: String?, 
        val baseRoleType: String,

        val isAccountRole: Boolean,

        val account: AccountEntity?,

        val workflowState: String,

        val createdAt: String,

        val lastUpdatedAt: String,

        val permissions: RolePermissionsEntity,
)

fun RoleEntity.translate(): Role {
    return Role(
        id = id,
        label = label,
        roleAlias = roleAlias,
        baseRoleType = baseRoleType,
        isAccountRole = isAccountRole,
        account = account,
        workflowState = workflowState,
        createdAt = createdAt,
        lastUpdatedAt = lastUpdatedAt,
        permissions = permissions
    )
}
