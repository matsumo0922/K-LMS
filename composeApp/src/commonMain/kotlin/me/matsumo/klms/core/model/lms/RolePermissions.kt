package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.RolePermissionsEntity

@Serializable
data class RolePermissions(
    val enabled: Boolean,
    val locked: Boolean,
    val appliesToSelf: Boolean?,
    val appliesToDescendants: Boolean?,
    val readonly: Boolean,
    val explicit: Boolean,
    val priorDefault: Boolean?,
)

fun RolePermissionsEntity.translate(): RolePermissions {
    return RolePermissions(
        enabled = enabled,
        locked = locked,
        appliesToSelf = appliesToSelf,
        appliesToDescendants = appliesToDescendants,
        readonly = readonly,
        explicit = explicit,
        priorDefault = priorDefault,
    )
}
