package me.matsumo.klms.core.model.lms

import androidx.compose.ui.input.key.Key.Companion.Calendar
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CalendarEventEntity
import me.matsumo.klms.core.model.lms.entity.GroupEntity
import me.matsumo.klms.core.model.lms.entity.UserEntity

@Serializable
data class CalendarEvent(
    val id: Int,

    val title: String,

    val startAt: String,

    val endAt: String,

    val description: String,

    val locationName: String,

    val locationAddress: String,

    val contextCode: String,

    val effectiveContextCode: String? = null,

    val contextName: String,

    val allContextCodes: String,

    val workflowState: String,

    val hidden: Boolean,

    val parentEventId: Int? = null,

    val childEventsCount: Int,

    val childEvents: List<CalendarEventEntity>? = null,

    val url: String,

    val htmlUrl: String,

    val allDayDate: Instant,

    val allDay: Boolean,

    val createdAt: String,

    val updatedAt: String,

    val appointmentGroupId: Int? = null,

    val appointmentGroupUrl: String? = null,

    val ownReservation: Boolean,

    val reserveUrl: String? = null,

    val reserved: Boolean,

    val participantType: String,

    val participantsPerAppointment: Int? = null,

    val availableSlots: Int? = null,

    val user: UserEntity? = null,

    val group: GroupEntity? = null,

    val importantDates: Boolean,

    val seriesUuid: String? = null,

    val rrule: String? = null,

    val seriesHead: Boolean? = null,

    val seriesNaturalLanguage: String? = null,

    val blackoutDate: Boolean
)

fun CalendarEventEntity.translate(): CalendarEvent {
    return CalendarEvent(
        id = id,
        title = title,
        startAt = startAt,
        endAt = endAt,
        description = description,
        locationName = locationName,
        locationAddress = locationAddress,
        contextCode = contextCode,
        effectiveContextCode = effectiveContextCode,
        contextName = contextName,
        allContextCodes = allContextCodes,
        workflowState = workflowState,
        hidden = hidden,
        parentEventId = parentEventId,
        childEventsCount = childEventsCount,
        childEvents = childEvents,
        url = url,
        htmlUrl = htmlUrl,
        allDayDate = Instant.parse(allDayDate),
        allDay = allDay,
        createdAt = createdAt,
        updatedAt = updatedAt,
        appointmentGroupId = appointmentGroupId,
        appointmentGroupUrl = appointmentGroupUrl,
        ownReservation = ownReservation,
        reserveUrl = reserveUrl,
        reserved = reserved,
        participantType = participantType,
        participantsPerAppointment = participantsPerAppointment,
        availableSlots = availableSlots,
        user = user,
        group = group,
        importantDates = importantDates,
        seriesUuid = seriesUuid,
        rrule = rrule,
        seriesHead = seriesHead,
        seriesNaturalLanguage = seriesNaturalLanguage,
        blackoutDate = blackoutDate
    )
}
