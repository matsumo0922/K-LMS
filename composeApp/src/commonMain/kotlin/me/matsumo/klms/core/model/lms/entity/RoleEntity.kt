package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoleEntity(
    // The id of the role
    @SerialName("id")
    val id: Int,

    // The label of the role
    @SerialName("label")
    val label: String,

    // The label of the role (Deprecated alias for 'label')
    @SerialName("role")
    val roleAlias: String?, // Deprecated but optional

    // The base role type
    @SerialName("base_role_type")
    val baseRoleType: String,

    // Whether this is an account role
    @SerialName("is_account_role")
    val isAccountRole: Boolean,

    // JSON representation of the account
    @SerialName("account")
    val account: me.matsumo.klms.core.model.lms.entity.AccountEntity?,

    // The state of the role
    @SerialName("workflow_state")
    val workflowState: String,

    // Time the role was created
    @SerialName("created_at")
    val createdAt: String,

    // Time the role was last updated
    @SerialName("last_updated_at")
    val lastUpdatedAt: String,

    // Dictionary of permissions by name
    @SerialName("permissions")
    val permissions: me.matsumo.klms.core.model.lms.entity.RolePermissionsEntity,
)
