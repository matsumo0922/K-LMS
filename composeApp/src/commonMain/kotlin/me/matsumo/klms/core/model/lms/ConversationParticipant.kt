package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ConversationParticipantEntity

@Serializable
data class ConversationParticipant(
    val id: Int,
    val name: String,
    val fullName: String,
    val avatarUrl: String? = null,
)

fun ConversationParticipantEntity.translate(): ConversationParticipant {
    return ConversationParticipant(
        id = id,
        name = name,
        fullName = fullName,
    )
}
