package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeChangeEventLinksEntity(
    // ID of the assignment associated with the event
    @SerialName("assignment")
    val assignment: Int,
    // ID of the course associated with the event. ...
    @SerialName("course")
    val course: Int,
    // ID of the student associated with the event. ...
    @SerialName("student")
    val student: Int,
    // ID of the grader associated with the event. ...
    @SerialName("grader")
    val grader: Int,
    // ID of the page view during the event if it exists.
    @SerialName("page_view")
    val pageView: String? = null,
)
