package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollaboratorEntity(
    // The unique user or group identifier for the collaborator.
    @SerialName("id")
    val id: Int,

    // The type of collaborator (e.g. 'user' or 'group').
    @SerialName("type")
    val type: String,

    // The name of the collaborator.
    @SerialName("name")
    val name: String
)
