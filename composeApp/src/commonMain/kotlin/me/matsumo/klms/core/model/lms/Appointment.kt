package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AppointmentEntity

@Serializable
data class Appointment(
    val id: Int,
    val startAt: String,
    val endAt: String,
)

fun AppointmentEntity.translate(): Appointment {
    return Appointment(
        id = id,
        startAt = startAt,
        endAt = endAt,
    )
}
