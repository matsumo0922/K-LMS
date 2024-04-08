package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppointmentEntity(
    // The appointment identifier.
    @SerialName("id") val id: Int,
    // Start time for the appointment
    @SerialName("start_at") val startAt: String,
    // End time for the appointment
    @SerialName("end_at") val endAt: String
)
