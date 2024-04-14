package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CommMessageEntity

@Serializable
data class CommMessage(
    val id: Int,
    val createdAt: Instant,
    val sentAt: Instant,
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
        createdAt = Instant.parse(createdAt),
        sentAt = Instant.parse(sentAt),
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
