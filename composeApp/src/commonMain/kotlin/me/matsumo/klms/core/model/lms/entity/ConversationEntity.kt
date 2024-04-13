package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationEntity(
    // the unique identifier for the conversation.
    @SerialName("id")
    val id: Int,
    // the subject of the conversation.
    @SerialName("subject")
    val subject: String,
    // The current state of the conversation (read, unread or archived).
    @SerialName("workflow_state")
    val workflowState: String,
    // A <=100 character preview from the most recent message.
    @SerialName("last_message")
    val lastMessage: String,
    // the date and time at which the last message was sent.
    @SerialName("start_at")
    val startAt: String,
    // the number of messages in the conversation.
    @SerialName("message_count")
    val messageCount: Int,
    // whether the current user is subscribed to the conversation.
    @SerialName("subscribed")
    val subscribed: Boolean,
    // whether the conversation is private.
    @SerialName("private")
    val private: Boolean,
    // whether the conversation is starred.
    @SerialName("starred")
    val starred: Boolean,
    // Additional conversation flags ...
    @SerialName("properties")
    val properties: List<String>? = null,
    // Array of user ids who are involved in the conversation ...
    @SerialName("audience")
    val audience: List<Int>? = null,
    // Most relevant shared contexts ...
    // @SerialName("audience_contexts")
    // val audienceContexts: Any? = null, // Placeholder type: You'll need more info on its structure

    // URL to appropriate icon for this conversation ...
    @SerialName("avatar_url")
    val avatarUrl: String,
    // Array of users participating in the conversation ...
    @SerialName("participants")
    val participants: List<me.matsumo.klms.core.model.lms.entity.UserEntity>? = null,
    // indicates whether the conversation is visible ...
    @SerialName("visible")
    val visible: Boolean,
    // Name of the course or group in which the conversation is occurring.
    @SerialName("context_name")
    val contextName: String,
)

// You'll likely need to define a 'User' data class as well, if not already defined.
