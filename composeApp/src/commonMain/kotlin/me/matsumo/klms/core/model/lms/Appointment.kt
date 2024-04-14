package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AppointmentEntity

@Serializable
data class Appointment(
    val id: Int,
    val startAt: Instant,
    val endAt: Instant,
)

fun AppointmentEntity.translate(): Appointment {
    return Appointment(
        id = id,
        startAt = Instant.parse(startAt),
        endAt = Instant.parse(endAt),
    )
}
