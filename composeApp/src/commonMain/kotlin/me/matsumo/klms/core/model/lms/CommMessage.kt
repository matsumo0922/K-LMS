package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CommMessageEntity

@Serializable
data class CommMessage(
    val id: Int,
    val createdAt: String,
    val sentAt: String,
    val workflowState: String,
    val from: String,
    val fromName: String,
    val to: String,
    val replyTo: String,
    val subject: String,
    val body: String,
    val htmlBody: String,
)

fun CommMessageEntity.translate(): CommMessage {
    return CommMessage(
        id = id,
        createdAt = createdAt,
        sentAt = sentAt,
        workflowState = workflowState,
        from = from,
        fromName = fromName,
        to = to,
        replyTo = replyTo,
        subject = subject,
        body = body,
        htmlBody = htmlBody,
    )
}
