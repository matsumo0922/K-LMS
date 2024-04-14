package me.matsumo.klms.core.model.lms.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseEntity(
    @SerialName("access_restricted_by_date")
    val accessRestrictedByDate: Boolean?,
    @SerialName("account_id")
    val accountId: Int,
    @SerialName("apply_assignment_group_weights")
    val applyAssignmentGroupWeights: Boolean,
    @SerialName("blueprint")
    val blueprint: Boolean,
    @SerialName("calendar")
    val calendar: Calendar,
    @SerialName("course_code")
    val courseCode: String,
    @SerialName("course_color")
    val courseColor: String?,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("default_view")
    val defaultView: String,
    @SerialName("end_at")
    val endAt: String?,
    @SerialName("enrollment_term_id")
    val enrollmentTermId: Int,
    @SerialName("enrollments")
    val enrollments: List<Enrollment>,
    @SerialName("friendly_name")
    val friendlyName: String?,
    @SerialName("grade_passback_setting")
    val gradePassbackSetting: String?,
    @SerialName("grading_standard_id")
    val gradingStandardId: String?,
    @SerialName("hide_final_grades")
    val hideFinalGrades: Boolean,
    @SerialName("homeroom_course")
    val homeroomCourse: Boolean,
    @SerialName("id")
    val id: Int,
    @SerialName("is_public")
    val isPublic: Boolean,
    @SerialName("is_public_to_auth_users")
    val isPublicToAuthUsers: Boolean,
    @SerialName("license")
    val license: String,
    @SerialName("name")
    val name: String,
    @SerialName("overridden_course_visibility")
    val overriddenCourseVisibility: String?,
    @SerialName("public_syllabus")
    val publicSyllabus: Boolean,
    @SerialName("public_syllabus_to_auth")
    val publicSyllabusToAuth: Boolean,
    @SerialName("restrict_enrollments_to_course_dates")
    val restrictEnrollmentsToCourseDates: Boolean,
    @SerialName("root_account_id")
    val rootAccountId: Int,
    @SerialName("start_at")
    val startAt: String?,
    @SerialName("storage_quota_mb")
    val storageQuotaMb: Int,
    @SerialName("template")
    val template: Boolean,
    @SerialName("time_zone")
    val timeZone: String,
    @SerialName("uuid")
    val uuid: String,
    @SerialName("workflow_state")
    val workflowState: String
) {
    @Serializable
    data class Calendar(
        @SerialName("ics")
        val ics: String
    )

    @Serializable
    data class Enrollment(
        @SerialName("enrollment_state")
        val enrollmentState: String,
        @SerialName("limit_privileges_to_course_section")
        val limitPrivilegesToCourseSection: Boolean,
        @SerialName("role")
        val role: String,
        @SerialName("role_id")
        val roleId: Int,
        @SerialName("type")
        val type: String,
        @SerialName("user_id")
        val userId: Int
    )
}
