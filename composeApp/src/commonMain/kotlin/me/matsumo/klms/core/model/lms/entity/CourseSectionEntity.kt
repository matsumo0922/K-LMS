package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseSectionEntity(
    // The unique identifier for the section.
    @SerialName("id")
    val id: Int,
    // The name of the section.
    @SerialName("name")
    val name: String,
    // The SIS ID of the section (if permissions allow)
    @SerialName("sis_section_id")
    val sisSectionId: String?,
    // Integration ID (if permissions allow)
    @SerialName("integration_id")
    val integrationId: String?,
    // SIS import ID (if permissions allow, and if created through SIS)
    @SerialName("sis_import_id")
    val sisImportId: Int?,
    // The course ID
    @SerialName("course_id")
    val courseId: Int,
    // SIS course ID (if permissions allow)
    @SerialName("sis_course_id")
    val sisCourseId: String?,
    // Start date of the section
    @SerialName("start_at")
    val startAt: String?,
    // End date of the section
    @SerialName("end_at")
    val endAt: String?,
    // Whether to restrict enrollments to section dates
    @SerialName("restrict_enrollments_to_section_dates")
    val restrictEnrollmentsToSectionDates: Boolean?,
    //  ID of original course in cross-listed sections
    @SerialName("nonxlist_course_id")
    val nonxlistCourseId: Int?,
    // Total number of active and invited students
    @SerialName("total_students")
    val totalStudents: Int?,
)
