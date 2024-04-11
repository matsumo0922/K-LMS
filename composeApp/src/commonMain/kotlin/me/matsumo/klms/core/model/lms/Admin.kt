package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AdminEntity

@Serializable
data class Admin(
        val id: Int,
        val role: String,
        val user: String?,
        val workflowState: String
)

fun AdminEntity.translate(): Admin {
    return Admin(
        id = id,
        role = role,
        user = user,
        workflowState = workflowState
    )
}
