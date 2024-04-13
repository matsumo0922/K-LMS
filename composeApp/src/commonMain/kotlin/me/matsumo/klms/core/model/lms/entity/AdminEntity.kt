package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AdminEntity(
    // The unique identifier for tnhe account role/user assignment.
    @SerialName("id") val id: Int,
    // The account role assigned. This can be 'AccountAdmin' or a user-defined role created by the Roles API.
    @SerialName("role") val role: String,
    // The user the role is assigned to. See the Users API for details.
    @SerialName("user") val user: String?,
    // The status of the account role/user assignment.
    @SerialName("workflow_state") val workflowState: String,
)
