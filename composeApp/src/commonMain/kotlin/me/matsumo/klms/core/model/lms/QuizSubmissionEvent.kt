package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizSubmissionEventEntity

@Serializable
data class QuizSubmissionEvent(
    val createdAt: String,
    val eventType: String,
    val eventData: Map<String, String>,
)

fun QuizSubmissionEventEntity.translate(): QuizSubmissionEvent {
    return QuizSubmissionEvent(
        createdAt = createdAt,
        eventType = eventType,
        eventData = eventData,
    )
}
