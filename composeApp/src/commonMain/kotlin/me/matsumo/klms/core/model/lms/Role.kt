package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.RoleEntity

@Serializable
data class Role(
    val id: Int,
    val label: String,
    val roleAlias: String?,
    val baseRoleType: String,
    val isAccountRole: Boolean,
    val account: LmsAccount?,
    val workflowState: String,
    val createdAt: Instant,
    val lastUpdatedAt: Instant,
    val permissions: RolePermissions,
)

fun RoleEntity.translate(): Role {
    return Role(
        id = id,
        label = label,
        roleAlias = roleAlias,
        baseRoleType = baseRoleType,
        isAccountRole = isAccountRole,
        account = account?.translate(),
        workflowState = workflowState,
        createdAt = Instant.parse(createdAt),
        lastUpdatedAt = Instant.parse(lastUpdatedAt),
        permissions = permissions.translate(),
    )
}
