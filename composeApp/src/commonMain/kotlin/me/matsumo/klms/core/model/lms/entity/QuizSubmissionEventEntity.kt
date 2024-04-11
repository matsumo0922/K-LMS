package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSubmissionEventEntity(
    // Timestamp of creation
    @SerialName("created_at")
    val createdAt: String,

    // The type of event
    @SerialName("event_type")
    val eventType: String,

    // Custom data for the event
    @SerialName("event_data")
    val eventData: Map<String, String> // Assuming key-value pairs
)
