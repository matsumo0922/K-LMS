package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseEntity

@Serializable
data class Course(
        val id: Int,

        val sisCourseId: String? = null,

        val uuid: String,

        val integrationId: String? = null,

        val sisImportId: Int? = null,

        val name: String,

        val courseCode: String,

        val originalName: String? = null,

        val workflowState: String,

        val accountId: Int,

        val rootAccountId: Int,

        val enrollmentTermId: Int,

            
        val gradingStandardId: Int,

        val gradePassbackSetting: String,

        val createdAt: String,

        val startAt: String? = null,

        val endAt: String? = null,

        val locale: String,

        val enrollments: EnrollmentEntity? = null, 
        val totalStudents: Int? = null,

        val calendar: CalendarLinkEntity? = null,

        val defaultView: String,

        val syllabusBody: String? = null,

        val needsGradingCount: Int? = null,

        val term: TermEntity? = null, 
        val courseProgress: CourseProgressEntity? = null, 
        val applyAssignmentGroupWeights: Boolean,

        val permissions: Map<String, Boolean>? = null, 
    val isPublic: Boolean,

    val isPublicToAuthUsers: Boolean,

    val publicSyllabus: Boolean,

    val publicSyllabusToAuth: Boolean,

        val publicDescription: String? = null,

    val storageQuotaMb: Int,

    val storageQuotaUsedMb: Int,

    val hideFinalGrades: Boolean,

    val license: String,

    val allowStudentAssignmentEdits: Boolean,

    val allowWikiComments: Boolean,

    val allowStudentForumAttachments: Boolean,

    val openEnrollment: Boolean,

    val selfEnrollment: Boolean,

    val restrictEnrollmentsToCourseDates: Boolean,

    val courseFormat: String,

        val accessRestrictedByDate: Boolean,

        val timeZone: String,

        val blueprint: Boolean? = null,

        val blueprintRestrictions: BlueprintRestrictionEntity? = null,

        val blueprintRestrictionsByObjectType: BlueprintRestrictionEntity? = null,

        val template: Boolean? = null
)

fun CourseEntity.translate(): Course {
    return Course(
        id = id,
        sisCourseId = sisCourseId,
        uuid = uuid,
        integrationId = integrationId,
        sisImportId = sisImportId,
        name = name,
        courseCode = courseCode,
        originalName = originalName,
        workflowState = workflowState,
        accountId = accountId,
        rootAccountId = rootAccountId,
        enrollmentTermId = enrollmentTermId,
        gradingStandardId = gradingStandardId,
        gradePassbackSetting = gradePassbackSetting,
        createdAt = createdAt,
        startAt = startAt,
        endAt = endAt,
        locale = locale,
        enrollments = enrollments,
        totalStudents = totalStudents,
        calendar = calendar,
        defaultView = defaultView,
        syllabusBody = syllabusBody,
        needsGradingCount = needsGradingCount,
        term = term,
        courseProgress = courseProgress,
        applyAssignmentGroupWeights = applyAssignmentGroupWeights,
        permissions = permissions,
        isPublic = isPublic,
        isPublicToAuthUsers = isPublicToAuthUsers,
        publicSyllabus = publicSyllabus,
        publicSyllabusToAuth = publicSyllabusToAuth,
        publicDescription = publicDescription,
        storageQuotaMb = storageQuotaMb,
        storageQuotaUsedMb = storageQuotaUsedMb,
        hideFinalGrades = hideFinalGrades,
        license = license,
        allowStudentAssignmentEdits = allowStudentAssignmentEdits,
        allowWikiComments = allowWikiComments,
        allowStudentForumAttachments = allowStudentForumAttachments,
        openEnrollment = openEnrollment,
        selfEnrollment = selfEnrollment,
        restrictEnrollmentsToCourseDates = restrictEnrollmentsToCourseDates,
        courseFormat = courseFormat,
        accessRestrictedByDate = accessRestrictedByDate,
        timeZone = timeZone,
        blueprint = blueprint,
        blueprintRestrictions = blueprintRestrictions,
        blueprintRestrictionsByObjectType = blueprintRestrictionsByObjectType
    )
}
