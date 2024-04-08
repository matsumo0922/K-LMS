package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnrollmentEntity(
    // The ID of the enrollment.
    @SerialName("id")
    val id: Int,

    // The unique id of the course.
    @SerialName("course_id")
    val courseId: Int,

    // The SIS Course ID in which the enrollment ...
    @SerialName("sis_course_id")
    val sisCourseId: String? = null,

    // The Course Integration ID in which the enrollment ...
    @SerialName("course_integration_id")
    val courseIntegrationId: String? = null,

    // The unique id of the user's section.
    @SerialName("course_section_id")
    val courseSectionId: Int,

    // The Section Integration ID in which the enrollment ...
    @SerialName("section_integration_id")
    val sectionIntegrationId: String? = null,

    // The SIS Account ID in which the enrollment ...
    @SerialName("sis_account_id")
    val sisAccountId: String? = null,

    // The SIS Section ID in which the enrollment ...
    @SerialName("sis_section_id")
    val sisSectionId: String? = null,

    // The SIS User ID in which the enrollment ...
    @SerialName("sis_user_id")
    val sisUserId: String? = null,

    // The state of the user's enrollment in the course.
    @SerialName("enrollment_state")
    val enrollmentState: String,

    // User can only access his or her own course section.
    @SerialName("limit_privileges_to_course_section")
    val limitPrivilegesToCourseSection: Boolean,

    // The unique identifier for the SIS import. ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null,

    // The unique id of the user's account.
    @SerialName("root_account_id")
    val rootAccountId: Int,

    // The enrollment type. ...
    @SerialName("type")
    val type: String,

    // The unique id of the user.
    @SerialName("user_id")
    val userId: Int,

    // The unique id of the associated user. ...
    @SerialName("associated_user_id")
    val associatedUserId: Int? = null,

    // The enrollment role, ...
    @SerialName("role")
    val role: String,

    // The id of the enrollment role.
    @SerialName("role_id")
    val roleId: Int,

    // The created time of the enrollment ...
    @SerialName("created_at")
    val createdAt: String,

    // The updated time of the enrollment ...
    @SerialName("updated_at")
    val updatedAt: String,

    // The start time of the enrollment ....
    @SerialName("start_at")
    val startAt: String,

    // The end time of the enrollment ...
    @SerialName("end_at")
    val endAt: String,

    // The last activity time of the user ...
    @SerialName("last_activity_at")
    val lastActivityAt: String,

    // The last attended date of the user ...
    @SerialName("last_attended_at")
    val lastAttendedAt: String? = null,

    // The total activity time of the user ...
    @SerialName("total_activity_time")
    val totalActivityTime: Int,

    // The URL to the Canvas web UI page for this course enrollment.
    @SerialName("html_url")
    val htmlUrl: String,

    // The URL to the Canvas web UI page ...
    @SerialName("grades")
    val grades: Grades,

    // A description of the user.
    @SerialName("user")
    val user: User,

    // The user's override grade ...
    @SerialName("override_grade")
    val overrideGrade: String? = null,

    // The user's override score ...
    @SerialName("override_score")
    val overrideScore: Double? = null,

    // The user's current grade in the class ...
    @SerialName("unposted_current_grade")
    val unpostedCurrentGrade: String? = null,

    // The user's final grade for the class ...
    @SerialName("unposted_final_grade")
    val unpostedFinalGrade: String? = null,

    // The user's current score in the class ...
    @SerialName("unposted_current_score")
    val unpostedCurrentScore: Double? = null,

    // The user's final score for the class ...
    @SerialName("unposted_final_score")
    val unpostedFinalScore: Double? = null,

    // optional: Indicates whether the course ...
    @SerialName("has_grading_periods")
    val hasGradingPeriods: Boolean? = null,

    // optional: Indicates whether the course ...
    @SerialName("totals_for_all_grading_periods_option")
    val totalsForAllGradingPeriodsOption: Boolean? = null,

    // optional: The name of the currently active grading period ...
    @SerialName("current_grading_period_title")
    val currentGradingPeriodTitle: String? = null,

    // optional: The id of the currently active grading period ...
    @SerialName("current_grading_period_id")
    val currentGradingPeriodId: Int? = null,

    // The user's override grade for the current grading period.
    @SerialName("current_period_override_grade")
    val currentPeriodOverrideGrade: String? = null,

    // The user's override score for the current grading period.
    @SerialName("current_period_override_score")
    val currentPeriodOverrideScore: Double? = null,

    // optional: The student's score in the course ...
    @SerialName("current_period_unposted_current_score")
    val currentPeriodUnpostedCurrentScore: Double? = null,

    // optional: The student's score in the course for the current ...
    @SerialName("current_period_unposted_final_score")
    val currentPeriodUnpostedFinalScore: Double? = null,

    // optional: The letter grade equivalent of ...
    @SerialName("current_period_unposted_current_grade")
    val currentPeriodUnpostedCurrentGrade: String? = null,

    // optional: The letter grade equivalent of ...
    @SerialName("current_period_unposted_final_grade")
    val currentPeriodUnpostedFinalGrade: String? = null
) {
    @Serializable
    data class Grades(
        @SerialName("html_url")
        val htmlUrl: String,

        @SerialName("current_score")
        val currentScore: Double? = null,

        @SerialName("current_grade")
        val currentGrade: String? = null,

        @SerialName("final_score")
        val finalScore: Double? = null,

        @SerialName("final_grade")
        val finalGrade: String? = null

    )

    @Serializable
    data class User(
        @SerialName("id")
        val id: Int,

        @SerialName("name")
        val name: String,

        @SerialName("sortable_name")
        val sortableName: String,

        @SerialName("short_name")
        val shortName: String
    )
}
