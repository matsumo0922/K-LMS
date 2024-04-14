package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ConferenceRecordingEntity

@Serializable
data class ConferenceRecording(
    val durationMinutes: Int,
    val title: String,
    val updatedAt: Instant,
    val createdAt: Instant,
    val playbackUrl: String,
)

fun ConferenceRecordingEntity.translate(): ConferenceRecording {
    return ConferenceRecording(
        durationMinutes = durationMinutes,
        title = title,
        updatedAt = Instant.parse(updatedAt),
        createdAt = Instant.parse(createdAt),
        playbackUrl = playbackUrl,
    )
}
