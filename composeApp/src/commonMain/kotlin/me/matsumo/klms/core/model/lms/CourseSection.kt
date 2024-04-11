package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseSectionEntity

@Serializable
data class CourseSection(
        val id: Int,

        val name: String,

        val sisSectionId: String?,

        val integrationId: String?,

        val sisImportId: Int?,

        val courseId: Int,

        val sisCourseId: String?,

        val startAt: String?,

        val endAt: String?,

        val restrictEnrollmentsToSectionDates: Boolean?,

        val nonxlistCourseId: Int?,

        val totalStudents: Int?
)

fun CourseSectionEntity.translate(): CourseSection {
    return CourseSection(
        id = id,
        name = name,
        sisSectionId = sisSectionId,
        integrationId = integrationId,
        sisImportId = sisImportId,
        courseId = courseId,
        sisCourseId = sisCourseId,
        startAt = startAt,
        endAt = endAt,
        restrictEnrollmentsToSectionDates = restrictEnrollmentsToSectionDates,
        nonxlistCourseId = nonxlistCourseId
    )
}
