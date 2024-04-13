package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeChangeEventEntity(
    // ID of the event.
    @SerialName("id")
    val id: String,
    // timestamp of the event
    @SerialName("created_at")
    val createdAt: String,
    // GradeChange event type
    @SerialName("event_type")
    val eventType: String,
    // Boolean indicating whether the submission was excused after ...
    @SerialName("excused_after")
    val excusedAfter: Boolean,
    // Boolean indicating whether the submission was excused before ...
    @SerialName("excused_before")
    val excusedBefore: Boolean,
    // The grade after the change.
    @SerialName("grade_after")
    val gradeAfter: String,
    // The grade before the change.
    @SerialName("grade_before")
    val gradeBefore: String,
    // Boolean indicating whether the student name was visible ...
    @SerialName("graded_anonymously")
    val gradedAnonymously: Boolean,
    // Version Number of the grade change submission.
    @SerialName("version_number")
    val versionNumber: String,
    // The unique request id of the request ...
    @SerialName("request_id")
    val requestId: String,
    @SerialName("links")
    val links: me.matsumo.klms.core.model.lms.entity.GradeChangeEventLinksEntity? = null, // Placeholder type for 'links' if needed
)
