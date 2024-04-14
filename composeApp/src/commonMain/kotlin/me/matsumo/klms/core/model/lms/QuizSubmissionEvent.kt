package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizSubmissionEventEntity

@Serializable
data class QuizSubmissionEvent(
    val createdAt: Instant,
    val eventType: String,
    val eventData: Map<String, String>,
)

fun QuizSubmissionEventEntity.translate(): QuizSubmissionEvent {
    return QuizSubmissionEvent(
        createdAt = Instant.parse(createdAt),
        eventType = eventType,
        eventData = eventData,
    )
}
