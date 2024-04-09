package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RolePermissionsEntity(
    // Whether the role has the permission
    @SerialName("enabled")
    val enabled: Boolean,

    // Whether the permission is locked by this role
    @SerialName("locked")
    val locked: Boolean,

    // Whether the permission applies to the account the role is in (if enabled)
    @SerialName("applies_to_self")
    val appliesToSelf: Boolean?,

    // Whether the permission applies to sub accounts (if enabled)
    @SerialName("applies_to_descendants")
    val appliesToDescendants: Boolean?,

    // Whether the permission can be modified in this role
    @SerialName("readonly")
    val readonly: Boolean,

    // Whether the value of 'enabled' is explicitly set here or inherited
    @SerialName("explicit")
    val explicit: Boolean,

    // The inherited value from upstream (if explicit = true)
    @SerialName("prior_default")
    val priorDefault: Boolean?
)
