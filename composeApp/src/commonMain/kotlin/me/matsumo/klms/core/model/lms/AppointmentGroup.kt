package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AppointmentGroupEntity

@Serializable
data class AppointmentGroup(
    val id: Int,
    val title: String,
    val startAt: String,
    val endAt: String,
    val description: String,
    val locationName: String,
    val locationAddress: String,
    val participantCount: Int,
    val reservedTimes: List<ReservedTime>,
    val allowObserverSignup: Boolean,
    val contextCodes: List<String>,
    val subContextCodes: List<String>,
    val workflowState: String,
    val requiringAction: Boolean,
    val appointmentsCount: Int,
    val appointments: List<String>,
    val newAppointments: List<String>,
    val maxAppointmentsPerParticipant: Int?,
    val minAppointmentsPerParticipant: Int,
    val participantsPerAppointment: Int?,
    val participantVisibility: String,
    val participantType: String,
    val url: String,
    val htmlUrl: String,
    val createdAt: String,
    val updatedAt: String,
) {
    @Serializable
    data class ReservedTime(
        val id: Int,
        val startAt: String,
        val endAt: String,
    )
}

fun AppointmentGroupEntity.translate(): AppointmentGroup {
    return AppointmentGroup(
        id = id,
        title = title,
        startAt = startAt,
        endAt = endAt,
        description = description,
        locationName = locationName,
        locationAddress = locationAddress,
        participantCount = participantCount,
        reservedTimes = reservedTimes.map {
            AppointmentGroup.ReservedTime(
                id = it.id,
                startAt = it.startAt,
                endAt = it.endAt,
            )
        },
        allowObserverSignup = allowObserverSignup,
        contextCodes = contextCodes,
        subContextCodes = subContextCodes,
        workflowState = workflowState,
        requiringAction = requiringAction,
        appointmentsCount = appointmentsCount,
        appointments = appointments,
        newAppointments = newAppointments,
        maxAppointmentsPerParticipant = maxAppointmentsPerParticipant,
        minAppointmentsPerParticipant = minAppointmentsPerParticipant,
        participantsPerAppointment = participantsPerAppointment,
        participantVisibility = participantVisibility,
        participantType = participantType,
        url = url,
        htmlUrl = htmlUrl,
        createdAt = createdAt,
        updatedAt = updatedAt,
    )
}
