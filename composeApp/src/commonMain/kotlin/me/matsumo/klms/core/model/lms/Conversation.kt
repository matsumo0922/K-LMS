package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

        val properties: List<String>? = null,

        val audience: List<Int>? = null,

            
        val avatarUrl: String,

        val participants: List<UserEntity>? = null,

        val visible: Boolean,

        val contextName: String
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
        properties = properties,
        audience = audience,
        avatarUrl = avatarUrl,
        participants = participants,
        visible = visible
    )
}
