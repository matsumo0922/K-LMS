package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradeChangeEventLinksEntity

@Serializable
data class GradeChangeEventLinks(
    val assignment: Int,
    val course: Int,
    val student: Int,
    val grader: Int,
    val pageView: String? = null,
)

fun GradeChangeEventLinksEntity.translate(): GradeChangeEventLinks {
    return GradeChangeEventLinks(
        assignment = assignment,
        course = course,
        student = student,
        grader = grader,
    )
}
