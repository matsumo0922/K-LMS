package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ConferenceRecordingEntity

@Serializable
data class ConferenceRecording(
    val durationMinutes: Int,

    val title: String,

    val updatedAt: String,

    val createdAt: String,

    val playbackUrl: String
)

fun ConferenceRecordingEntity.translate(): ConferenceRecording {
    return ConferenceRecording(
        durationMinutes = durationMinutes,
        title = title,
        updatedAt = updatedAt,
        createdAt = createdAt,
        playbackUrl = playbackUrl
    )
}
