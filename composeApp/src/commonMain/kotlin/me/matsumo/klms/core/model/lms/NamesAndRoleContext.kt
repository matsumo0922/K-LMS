package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleContext(
    val id: String,

    val label: String,

    val title: String
)

fun NamesAndRoleContextEntity.translate(): NamesAndRoleContext {
    return NamesAndRoleContext(
        id = id,
        label = label
    )
}
