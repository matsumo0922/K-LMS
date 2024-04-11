package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeChangeEventLinks(
        val assignment: Int,

        val course: Int,

        val student: Int,

        val grader: Int,

        val pageView: String? = null
)

fun GradeChangeEventLinksEntity.translate(): GradeChangeEventLinks {
    return GradeChangeEventLinks(
        assignment = assignment,
        course = course,
        student = student,
        grader = grader
    )
}
