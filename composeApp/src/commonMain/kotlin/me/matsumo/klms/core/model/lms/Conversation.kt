package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ConversationEntity

@Serializable
data class Conversation(
    val id: Int,
    val subject: String,
    val workflowState: String,
    val lastMessage: String,
    val startAt: String,
    val messageCount: Int,
    val subscribed: Boolean,
    val private: Boolean,
    val starred: Boolean,
    val properties: List<String> = emptyList(),
    val audience: List<Int> = emptyList(),
    val avatarUrl: String,
    val participants: List<LmsUser> = emptyList(),
    val visible: Boolean,
    val contextName: String,
)

fun ConversationEntity.translate(): Conversation {
    return Conversation(
        id = id,
        subject = subject,
        workflowState = workflowState,
        lastMessage = lastMessage,
        startAt = startAt,
        messageCount = messageCount,
        subscribed = subscribed,
        private = private,
        starred = starred,
        properties = properties ?: emptyList(),
        audience = audience ?: emptyList(),
        avatarUrl = avatarUrl,
        participants = participants?.map { it.translate() } ?: emptyList(),
        visible = visible,
        contextName = contextName,
    )
}
