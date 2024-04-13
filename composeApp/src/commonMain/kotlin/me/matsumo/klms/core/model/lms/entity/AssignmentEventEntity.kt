package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssignmentEventEntity(
    // A synthetic ID for the assignment
    @SerialName("id")
    val id: String,
    // The title of the assignment
    @SerialName("title")
    val title: String,
    // The due_at timestamp of the assignment
    @SerialName("start_at")
    val startAt: String,
    // The due_at timestamp of the assignment
    @SerialName("end_at")
    val endAt: String,
    // The HTML description of the assignment
    @SerialName("description")
    val description: String,
    // the context code of the (course) calendar this assignment belongs to
    @SerialName("context_code")
    val contextCode: String,
    // Current state of the assignment ('published' or 'deleted')
    @SerialName("workflow_state")
    val workflowState: String,
    // URL for this assignment (note that updating/deleting should be done via the
    // Assignments API)
    @SerialName("url")
    val url: String,
    // URL for a user to view this assignment
    @SerialName("html_url")
    val htmlUrl: String,
    // The due date of this assignment
    @SerialName("all_day_date")
    val allDayDate: String,
    // Boolean indicating whether this is an all-day event (e.g. assignment due at
    // midnight)
    @SerialName("all_day")
    val allDay: Boolean,
    // When the assignment was created
    @SerialName("created_at")
    val createdAt: String,
    // When the assignment was last updated
    @SerialName("updated_at")
    val updatedAt: String,
    // The full assignment JSON data (See the Assignments API)
    @SerialName("assignment")
    val assignment: me.matsumo.klms.core.model.lms.entity.AssignmentEntity? = null, // Placeholder type. You'd need the full 'assignment' structure to define this more precisely

    // The list of AssignmentOverrides that apply to this event
    @SerialName("assignment_overrides")
    val assignmentOverrides: me.matsumo.klms.core.model.lms.entity.AssignmentOverrideEntity? = null, // Placeholder type (same as above)

    @SerialName("important_dates")
    val importantDates: Boolean,
    // An iCalendar RRULE for defining how events in a recurring event series repeat.
    @SerialName("rrule")
    val rrule: String,
    @SerialName("series_head")
    val seriesHead: Boolean? = null,
    @SerialName("series_natural_language")
    val seriesNaturalLanguage: String? = null,
)
