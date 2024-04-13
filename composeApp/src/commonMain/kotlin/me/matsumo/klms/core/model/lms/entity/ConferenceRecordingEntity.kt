package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConferenceRecordingEntity(
    @SerialName("duration_minutes")
    val durationMinutes: Int,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("playback_url")
    val playbackUrl: String,
)
