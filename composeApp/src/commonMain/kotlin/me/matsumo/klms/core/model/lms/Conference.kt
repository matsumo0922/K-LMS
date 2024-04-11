package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.translate
import me.matsumo.klms.core.model.lms.entity.ConferenceEntity

@Serializable
data class Conference(
    val id: Int,

    val conferenceType: String,

    val conferenceKey: String,

    val description: String,

    val duration: Int,

    val endedAt: String? = null,

    val startedAt: String? = null,

    val title: String,

    val users: List<Int>,

    val hasAdvancedSettings: Boolean,

    val longRunning: Boolean,

    val userSettings: Map<String, Boolean>,

    val recordings: List<ConferenceRecording>? = null,
    val url: String? = null,

    val joinUrl: String? = null,

    val contextType: String? = null,

    val contextId: Int? = null
)

fun ConferenceEntity.translate(): Conference {
    return Conference(
        id = id,
        conferenceType = conferenceType,
        conferenceKey = conferenceKey,
        description = description,
        duration = duration,
        endedAt = endedAt,
        startedAt = startedAt,
        title = title,
        users = users,
        hasAdvancedSettings = hasAdvancedSettings,
        longRunning = longRunning,
        userSettings = userSettings,
        recordings = recordings?.map { it.translate() },
        url = url,
        joinUrl = joinUrl,
        contextType = contextType
    )
}
