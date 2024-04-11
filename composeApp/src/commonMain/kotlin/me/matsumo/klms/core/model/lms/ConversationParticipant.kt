package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationParticipant(
        val id: Int,

        val name: String,

        val fullName: String,

        val avatarUrl: String? = null
)

fun ConversationParticipantEntity.translate(): ConversationParticipant {
    return ConversationParticipant(
        id = id,
        name = name,
        fullName = fullName
    )
}
