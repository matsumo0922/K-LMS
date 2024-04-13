package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.NamesAndRoleMembershipsEntity

@Serializable
data class NamesAndRoleMemberships(
    val context: Context,
    val id: String,
    val members: List<NamesAndRoleMembership>,
) {
    @Serializable
    data class Context(
        val id: String,
        val label: String,
        val title: String,
    )
}

fun NamesAndRoleMembershipsEntity.translate(): NamesAndRoleMemberships {
    return NamesAndRoleMemberships(
        id = id,
        context = NamesAndRoleMemberships.Context(
            id = context.id,
            label = context.label,
            title = context.title,
        ),
        members = members.map { it.translate() },
    )
}
