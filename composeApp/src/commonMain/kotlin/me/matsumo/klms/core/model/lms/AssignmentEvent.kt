package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssignmentEntity
import me.matsumo.klms.core.model.lms.entity.AssignmentEventEntity
import me.matsumo.klms.core.model.lms.entity.AssignmentOverrideEntity

@Serializable
data class AssignmentEvent(
    val id: String,
    val title: String,
    val startAt: String,
    val endAt: String,
    val description: String,
    val contextCode: String,
    val workflowState: String,
    val url: String,
    val htmlUrl: String,
    val allDayDate: Instant,
    val allDay: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val assignment: AssignmentEntity? = null,
    val assignmentOverrides: AssignmentOverrideEntity? = null,
    val importantDates: Boolean,
    val rrule: String,
    val seriesHead: Boolean? = null,
    val seriesNaturalLanguage: String? = null,
)

fun AssignmentEventEntity.translate(): AssignmentEvent {
    return AssignmentEvent(
        id = id,
        title = title,
        startAt = startAt,
        endAt = endAt,
        description = description,
        contextCode = contextCode,
        workflowState = workflowState,
        url = url,
        htmlUrl = htmlUrl,
        allDayDate = Instant.parse(allDayDate),
        allDay = allDay,
        createdAt = createdAt,
        updatedAt = updatedAt,
        assignment = assignment,
        assignmentOverrides = assignmentOverrides,
        importantDates = importantDates,
        rrule = rrule,
        seriesHead = seriesHead,
    )
}
