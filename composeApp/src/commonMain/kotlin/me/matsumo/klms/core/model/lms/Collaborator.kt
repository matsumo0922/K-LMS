package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CollaboratorEntity

@Serializable
data class Collaborator(
    val id: Int,
    val type: String,
    val name: String,
)

fun CollaboratorEntity.translate(): Collaborator {
    return Collaborator(
        id = id,
        type = type,
        name = name,
    )
}
