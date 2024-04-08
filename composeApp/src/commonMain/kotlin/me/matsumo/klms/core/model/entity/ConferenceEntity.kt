package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class ConferenceEntity(
    // The id of the conference
    @SerialName("id")
    val id: Int,

    // The type of conference
    @SerialName("conference_type")
    val conferenceType: String,

    // The 3rd party's ID for the conference
    @SerialName("conference_key")
    val conferenceKey: String,

    // The description for the conference
    @SerialName("description")
    val description: String,

    // The expected duration the conference is supposed to last
    @SerialName("duration")
    val duration: Int,

    // The date that the conference ended at, null if it hasn't ended
    @SerialName("ended_at")
    val endedAt: String? = null,

    // The date the conference started at, null if it hasn't started
    @SerialName("started_at")
    val startedAt: String? = null,

    // The title of the conference
    @SerialName("title")
    val title: String,

    // Array of user ids that are participants in the conference
    @SerialName("users")
    val users: List<Int>,

    // True if the conference type has advanced settings.
    @SerialName("has_advanced_settings")
    val hasAdvancedSettings: Boolean,

    // If true the conference is long running and has no expected end time
    @SerialName("long_running")
    val longRunning: Boolean,

    // A collection of settings specific to the conference type
    @SerialName("user_settings")
    val userSettings: Map<String, Boolean>,

    // A List of recordings for the conference
    @SerialName("recordings")
    val recordings: List<ConferenceRecordingEntity>? = null, // Placeholder type - you'll need the structure of 'Recording'

    // URL for the conference, may be null if the conference type doesn't set it
    @SerialName("url")
    val url: String? = null,

    // URL to join the conference, may be null if the conference type doesn't set it
    @SerialName("join_url")
    val joinUrl: String? = null,

    // The type of this conference's context, typically 'Course' or 'Group'.
    @SerialName("context_type")
    val contextType: String? = null,

    // The ID of this conference's context.
    @SerialName("context_id")
    val contextId: Int? = null
)
