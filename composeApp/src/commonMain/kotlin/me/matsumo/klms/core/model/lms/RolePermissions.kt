package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RolePermissions(
        val enabled: Boolean,

        val locked: Boolean,

        val appliesToSelf: Boolean?,

        val appliesToDescendants: Boolean?,

        val readonly: Boolean,

        val explicit: Boolean,

        val priorDefault: Boolean?
)

fun RolePermissionsEntity.translate(): RolePermissions {
    return RolePermissions(
        enabled = enabled,
        locked = locked,
        appliesToSelf = appliesToSelf,
        appliesToDescendants = appliesToDescendants,
        readonly = readonly,
        explicit = explicit
    )
}
