package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationParticipantEntity(
    // The user ID for the participant.
    @SerialName("id")
    val id: Int,

    // A short name the user has selected ...
    @SerialName("name")
    val name: String,

    // The full name of the user.
    @SerialName("full_name")
    val fullName: String,

    // If requested, this field will be included ...
    @SerialName("avatar_url")
    val avatarUrl: String? = null
)
