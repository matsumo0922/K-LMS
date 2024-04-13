package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Blackout dates are used to prevent scheduling assignments on a given date in course pacing.
@Serializable
data class BlackoutDateEntity(
    // the ID of the blackout date
    @SerialName("id") val id: Int,
    // the context owning the blackout date
    @SerialName("context_id") val contextId: Int,
    @SerialName("context_type") val contextType: String,
    // the start date of the blackout date
    @SerialName("start_date") val startDate: String,
    // the end date of the blackout date
    @SerialName("end_date") val endDate: String,
    // title of the blackout date
    @SerialName("event_title") val eventTitle: String,
)
