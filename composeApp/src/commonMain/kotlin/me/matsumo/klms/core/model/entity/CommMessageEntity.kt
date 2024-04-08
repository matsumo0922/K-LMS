package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommMessageEntity(
    // The ID of the CommMessage.
    @SerialName("id")
    val id: Int,

    // The date and time this message was created
    @SerialName("created_at")
    val createdAt: String,

    // The date and time this message was sent
    @SerialName("sent_at")
    val sentAt: String,

    // The workflow state of the message. ...
    @SerialName("workflow_state")
    val workflowState: String,

    // The address that was put in the 'from' field of the message
    @SerialName("from")
    val from: String,

    // The display name for the from address
    @SerialName("from_name")
    val fromName: String,

    // The address the message was sent to:
    @SerialName("to")
    val to: String,

    // The reply_to header of the message
    @SerialName("reply_to")
    val replyTo: String,

    // The message subject
    @SerialName("subject")
    val subject: String,

    // The plain text body of the message
    @SerialName("body")
    val body: String,

    // The HTML body of the message.
    @SerialName("html_body")
    val htmlBody: String
)
