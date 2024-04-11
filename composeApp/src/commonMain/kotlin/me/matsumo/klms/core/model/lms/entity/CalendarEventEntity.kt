package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarEventEntity(
    // The ID of the calendar event
    @SerialName("id")
    val id: Int,

    // The title of the calendar event
    @SerialName("title")
    val title: String,

    // The start timestamp of the event
    @SerialName("start_at")
    val startAt: String,

    // The end timestamp of the event
    @SerialName("end_at")
    val endAt: String,

    // The HTML description of the event
    @SerialName("description")
    val description: String,

    // The location name of the event
    @SerialName("location_name")
    val locationName: String,

    // The address where the event is taking place
    @SerialName("location_address")
    val locationAddress: String,

    // the context code of the calendar this event belongs to (course, group, user,
    // or account)
    @SerialName("context_code")
    val contextCode: String,

    // if specified, it indicates which calendar this event should be displayed on.
    // for example, a section-level event would have the course's context code here,
    // while the section's context code would be returned above)
    @SerialName("effective_context_code")
    val effectiveContextCode: String? = null,

    // the context name of the calendar this event belongs to (course, user or
    // group)
    @SerialName("context_name")
    val contextName: String,

    // a comma-separated list of all calendar contexts this event is part of
    @SerialName("all_context_codes")
    val allContextCodes: String,

    // Current state of the event ('active', 'locked' or 'deleted') 'locked'
    // indicates that start_at/end_at cannot be changed (though the event could be
    // deleted). Normally only reservations or time slots with reservations are
    // locked (see the Appointment Groups API)
    @SerialName("workflow_state")
    val workflowState: String,

    // Whether this event should be displayed on the calendar. Only true for
    // course-level events with section-level child events.
    @SerialName("hidden")
    val hidden: Boolean,

    // Normally null. If this is a reservation (see the Appointment Groups API), the
    // id will indicate the time slot it is for. If this is a section-level event,
    // this will be the course-level parent event.
    @SerialName("parent_event_id")
    val parentEventId: Int? = null,

    // The number of child_events. See child_events (and parent_event_id)
    @SerialName("child_events_count")
    val childEventsCount: Int,

    // Included by default, but may be excluded (see include[] option). If this is a
    // time slot (see the Appointment Groups API) this will be a list of any
    // reservations. If this is a course-level event, this will be a list of
    // section-level events (if any)
    @SerialName("child_events")
    val childEvents: List<me.matsumo.klms.core.model.lms.entity.CalendarEventEntity>? = null,

    // URL for this calendar event (to update, delete, etc.)
    @SerialName("url")
    val url: String,

    // URL for a user to view this event
    @SerialName("html_url")
    val htmlUrl: String,

    // The date of this event
    @SerialName("all_day_date")
    val allDayDate: String,

    // Boolean indicating whether this is an all-day event (midnight to midnight)
    @SerialName("all_day")
    val allDay: Boolean,

    // When the calendar event was created
    @SerialName("created_at")
    val createdAt: String,

    // When the calendar event was last updated
    @SerialName("updated_at")
    val updatedAt: String,

    // Various Appointment-Group-related fields. ...
    @SerialName("appointment_group_id")
    val appointmentGroupId: Int? = null,

    @SerialName("appointment_group_url")
    val appointmentGroupUrl: String? = null,

    @SerialName("own_reservation")
    val ownReservation: Boolean,

    @SerialName("reserve_url")
    val reserveUrl: String? = null,

    @SerialName("reserved")
    val reserved: Boolean,

    @SerialName("participant_type")
    val participantType: String,

    @SerialName("participants_per_appointment")
    val participantsPerAppointment: Int? = null,

    @SerialName("available_slots")
    val availableSlots: Int? = null,

    // If the event is a user-level reservation, this will contain ...
    @SerialName("user")
    val user: me.matsumo.klms.core.model.lms.entity.UserEntity? = null,

    // If the event is a group-level reservation, this will contain ...
    @SerialName("group")
    val group: me.matsumo.klms.core.model.lms.entity.GroupEntity? = null,

    @SerialName("important_dates")
    val importantDates: Boolean,

    @SerialName("series_uuid")
    val seriesUuid: String? = null,

    @SerialName("rrule")
    val rrule: String? = null,

    @SerialName("series_head")
    val seriesHead: Boolean? = null,

    @SerialName("series_natural_language")
    val seriesNaturalLanguage: String? = null,

    @SerialName("blackout_date")
    val blackoutDate: Boolean
)
