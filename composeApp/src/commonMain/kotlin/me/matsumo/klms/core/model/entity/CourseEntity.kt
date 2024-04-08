package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseEntity(
    // the unique identifier for the course
    @SerialName("id")
    val id: Int,

    // the SIS identifier for the course, if defined...
    @SerialName("sis_course_id")
    val sisCourseId: String? = null,

    // the UUID of the course
    @SerialName("uuid")
    val uuid: String,

    // the integration identifier for the course, if defined ...
    @SerialName("integration_id")
    val integrationId: String? = null,

    // the unique identifier for the SIS import. ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null,

    // the full name of the course. ...
    @SerialName("name")
    val name: String,

    // the course code
    @SerialName("course_code")
    val courseCode: String,

    // the actual course name. ...
    @SerialName("original_name")
    val originalName: String? = null,

    // the current state of the course ...
    @SerialName("workflow_state")
    val workflowState: String,

    // the account associated with the course
    @SerialName("account_id")
    val accountId: Int,

    // the root account associated with the course
    @SerialName("root_account_id")
    val rootAccountId: Int,

    // the enrollment term associated with the course
    @SerialName("enrollment_term_id")
    val enrollmentTermId: Int,

    // A list of grading periods associated with the course
    @SerialName("grading_periods")
    val gradingPeriods: Any? = null, // Placeholder type - you'll need to define its structure

    // the grading standard associated with the course
    @SerialName("grading_standard_id")
    val gradingStandardId: Int,

    // the grade_passback_setting set on the course
    @SerialName("grade_passback_setting")
    val gradePassbackSetting: String,

    // the date the course was created.
    @SerialName("created_at")
    val createdAt: String,

    // the start date for the course, if applicable
    @SerialName("start_at")
    val startAt: String? = null,

    // the end date for the course, if applicable
    @SerialName("end_at")
    val endAt: String? = null,

    // the course-set locale, if applicable
    @SerialName("locale")
    val locale: String,

    // A list of enrollments linking the ...
    @SerialName("enrollments")
    val enrollments: Any? = null, // Placeholder - structure needed

    // optional: the total number of active and invited students ...
    @SerialName("total_students")
    val totalStudents: Int? = null,

    // course calendar
    @SerialName("calendar")
    val calendar: CalendarLink? = null,

    // the type of page that users will see ...
    @SerialName("default_view")
    val defaultView: String,

    // optional: user-generated HTML for the course syllabus
    @SerialName("syllabus_body")
    val syllabusBody: String? = null,

    // optional: the number of submissions needing grading ...
    @SerialName("needs_grading_count")
    val needsGradingCount: Int? = null,

    // optional: the enrollment term object for the course ...
    @SerialName("term")
    val term: Any? = null, // Placeholder type needed

    // optional: information on progress through the course ...
    @SerialName("course_progress")
    val courseProgress: Any? = null, // Placeholder type needed

    // weight final grade based on assignment group percentages
    @SerialName("apply_assignment_group_weights")
    val applyAssignmentGroupWeights: Boolean,

    // optional: the permissions the user has for the course ...
    @SerialName("permissions")
    val permissions: Map<String, Boolean>? = null, // Permissions can vary

    @SerialName("is_public")
    val isPublic: Boolean,

    @SerialName("is_public_to_auth_users")
    val isPublicToAuthUsers: Boolean,

    @SerialName("public_syllabus")
    val publicSyllabus: Boolean,

    @SerialName("public_syllabus_to_auth")
    val publicSyllabusToAuth: Boolean,

    // optional: the public description of the course
    @SerialName("public_description")
    val publicDescription: String? = null,

    @SerialName("storage_quota_mb")
    val storageQuotaMb: Int,

    @SerialName("storage_quota_used_mb")
    val storageQuotaUsedMb: Int,

    @SerialName("hide_final_grades")
    val hideFinalGrades: Boolean,

    @SerialName("license")
    val license: String,

    @SerialName("allow_student_assignment_edits")
    val allowStudentAssignmentEdits: Boolean,

    @SerialName("allow_wiki_comments")
    val allowWikiComments: Boolean,

    @SerialName("allow_student_forum_attachments")
    val allowStudentForumAttachments: Boolean,

    @SerialName("open_enrollment")
    val openEnrollment: Boolean,

    @SerialName("self_enrollment")
    val selfEnrollment: Boolean,

    @SerialName("restrict_enrollments_to_course_dates")
    val restrictEnrollmentsToCourseDates: Boolean,

    @SerialName("course_format")
    val courseFormat: String,

    // optional: this will be true if ...
    @SerialName("access_restricted_by_date")
    val accessRestrictedByDate: Boolean,

    // The course's IANA time zone name.
    @SerialName("time_zone")
    val timeZone: String,

    // optional: whether the course is set as a Blueprint Course ...
    @SerialName("blueprint")
    val blueprint: Boolean? = null,

    // optional: Set of restrictions applied to all ...
    @SerialName("blueprint_restrictions")
    val blueprintRestrictions: BlueprintRestrictions? = null,

    // optional: Sets of restrictions differentiated by object type ...
    @SerialName("blueprint_restrictions_by_object_type")
    val blueprintRestrictionsByObjectType: BlueprintRestrictionsByObjectType? = null,

    // optional: whether the course is set as a template ...
    @SerialName("template")
    val template: Boolean? = null
) {

    @Serializable
    data class BlueprintRestrictions(
        val content: Boolean,
        val points: Boolean,
        @SerialName("due_dates")
        val dueDates: Boolean,
        @SerialName("availability_dates")
        val availabilityDates: Boolean
    )
}
