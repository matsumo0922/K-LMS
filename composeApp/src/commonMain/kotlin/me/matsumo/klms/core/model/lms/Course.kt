package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseEntity

@Serializable
data class Course(
    val accessRestrictedByDate: Boolean,
    val accountId: Int,
    val applyAssignmentGroupWeights: Boolean,
    val blueprint: Boolean,
    val calendar: CourseEntity.Calendar,
    val courseCode: String,
    val courseColor: String?,
    val createdAt: Instant,
    val defaultView: String,
    val endAt: Instant?,
    val enrollmentTermId: Int,
    val enrollments: List<Enrollment>,
    val friendlyName: String?,
    val gradePassbackSetting: String?,
    val gradingStandardId: String?,
    val hideFinalGrades: Boolean,
    val homeroomCourse: Boolean,
    val id: Int,
    val isPublic: Boolean,
    val isPublicToAuthUsers: Boolean,
    val license: String,
    val name: String,
    val overriddenCourseVisibility: String?,
    val publicSyllabus: Boolean,
    val publicSyllabusToAuth: Boolean,
    val restrictEnrollmentsToCourseDates: Boolean,
    val rootAccountId: Int,
    val startAt: Instant?,
    val storageQuotaMb: Int,
    val template: Boolean,
    val timeZone: String,
    val uuid: String,
    val workflowState: String
) {
    @Serializable
    data class Enrollment(
        val enrollmentState: String,
        val limitPrivilegesToCourseSection: Boolean,
        val role: String,
        val roleId: Int,
        val type: String,
        val userId: Int
    )
}

fun CourseEntity.translate(): Course {
    return Course(
        accessRestrictedByDate = accessRestrictedByDate ?: false,
        accountId = accountId,
        applyAssignmentGroupWeights = applyAssignmentGroupWeights,
        blueprint = blueprint,
        calendar = calendar,
        courseCode = courseCode,
        courseColor = courseColor,
        createdAt = Instant.parse(createdAt),
        defaultView = defaultView,
        endAt = endAt?.let { Instant.parse(it) },
        enrollmentTermId = enrollmentTermId,
        enrollments = enrollments.map {
            Course.Enrollment(
                enrollmentState = it.enrollmentState,
                limitPrivilegesToCourseSection = it.limitPrivilegesToCourseSection,
                role = it.role,
                roleId = it.roleId,
                type = it.type,
                userId = it.userId
            )
        },
        friendlyName = friendlyName,
        gradePassbackSetting = gradePassbackSetting,
        gradingStandardId = gradingStandardId,
        hideFinalGrades = hideFinalGrades,
        homeroomCourse = homeroomCourse,
        id = id,
        isPublic = isPublic,
        isPublicToAuthUsers = isPublicToAuthUsers,
        license = license,
        name = name,
        overriddenCourseVisibility = overriddenCourseVisibility,
        publicSyllabus = publicSyllabus,
        publicSyllabusToAuth = publicSyllabusToAuth,
        restrictEnrollmentsToCourseDates = restrictEnrollmentsToCourseDates,
        rootAccountId = rootAccountId,
        startAt = startAt?.let { Instant.parse(it) },
        storageQuotaMb = storageQuotaMb,
        template = template,
        timeZone = timeZone,
        uuid = uuid,
        workflowState = workflowState
    )
}
