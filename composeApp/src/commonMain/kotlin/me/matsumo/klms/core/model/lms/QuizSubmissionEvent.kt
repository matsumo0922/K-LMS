package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSubmissionEvent(
        val createdAt: String,

        val eventType: String,

        val eventData: Map<String, String> )

fun QuizSubmissionEventEntity.translate(): QuizSubmissionEvent {
    return QuizSubmissionEvent(
        createdAt = createdAt,
        eventType = eventType,
        eventData = eventData
    )
}
