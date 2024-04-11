package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppointmentGroupEntity(
    // The ID of the appointment group
    @SerialName("id") val id: Int,
    // The title of the appointment group
    @SerialName("title") val title: String,
    // The start of the first time slot in the appointment group
    @SerialName("start_at") val startAt: String,
    // The end of the last time slot in the appointment group
    @SerialName("end_at") val endAt: String,
    // The text description of the appointment group
    @SerialName("description") val description: String,
    // The location name of the appointment group
    @SerialName("location_name") val locationName: String,
    // The address of the appointment group's location
    @SerialName("location_address") val locationAddress: String,
    // The number of participant who have reserved slots
    @SerialName("participant_count") val participantCount: Int,
    // The start and end times of slots reserved by the current user as well as the id of the calendar event for the reservation
    @SerialName("reserved_times") val reservedTimes: List<me.matsumo.klms.core.model.lms.entity.AppointmentGroupEntity.ReservedTime>,
    // Boolean indicating whether observer users should be able to sign-up for an appointment
    @SerialName("allow_observer_signup") val allowObserverSignup: Boolean,
    // The context codes this appointment group belongs to. Only people in these courses will be eligible to sign up.
    @SerialName("context_codes") val contextCodes: List<String>,
    // The sub-context codes this appointment group is restricted to
    @SerialName("sub_context_codes") val subContextCodes: List<String>,
    // Current state of the appointment group ('pending', 'active' or 'deleted').
    @SerialName("workflow_state") val workflowState: String,
    // Boolean indicating whether the current user needs to sign up for this appointment group
    @SerialName("requiring_action") val requiringAction: Boolean,
    // Number of time slots in this appointment group
    @SerialName("appointments_count") val appointmentsCount: Int,
    // Calendar Events representing the time slots
    @SerialName("appointments") val appointments: List<String>,
    // Newly created time slots. Only returned in Create/Update responses where new time slots have been added
    @SerialName("new_appointments") val newAppointments: List<String>,
    // Maximum number of time slots a user may register for, or null if no limit
    @SerialName("max_appointments_per_participant") val maxAppointmentsPerParticipant: Int?,
    // Minimum number of time slots a user must register for. If not set, users do not need to sign up for any time slots
    @SerialName("min_appointments_per_participant") val minAppointmentsPerParticipant: Int,
    // Maximum number of participants that may register for each time slot, or null if no limit
    @SerialName("participants_per_appointment") val participantsPerAppointment: Int?,
    // 'private' means participants cannot see who has signed up for a particular time slot, 'protected' means that they can
    @SerialName("participant_visibility") val participantVisibility: String,
    // Indicates how participants sign up for the appointment group, either as individuals ('User') or in student groups ('Group').
    @SerialName("participant_type") val participantType: String,
    // URL for this appointment group (to update, delete, etc.)
    @SerialName("url") val url: String,
    // URL for a user to view this appointment group
    @SerialName("html_url") val htmlUrl: String,
    // When the appointment group was created
    @SerialName("created_at") val createdAt: String,
    // When the appointment group was last updated
    @SerialName("updated_at") val updatedAt: String
) {
    @Serializable
    data class ReservedTime(
        @SerialName("id") val id: Int,
        @SerialName("start_at") val startAt: String,
        @SerialName("end_at") val endAt: String
    )
}
