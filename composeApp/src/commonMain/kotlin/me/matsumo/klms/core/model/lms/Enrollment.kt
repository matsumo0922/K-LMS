package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Enrollment(
        val id: Int,

        val courseId: Int,

        val sisCourseId: String? = null,

        val courseIntegrationId: String? = null,

        val courseSectionId: Int,

        val sectionIntegrationId: String? = null,

        val sisAccountId: String? = null,

        val sisSectionId: String? = null,

        val sisUserId: String? = null,

        val enrollmentState: String,

        val limitPrivilegesToCourseSection: Boolean,

        val sisImportId: Int? = null,

        val rootAccountId: Int,

        val type: String,

        val userId: Int,

        val associatedUserId: Int? = null,

        val role: String,

        val roleId: Int,

        val createdAt: String,

        val updatedAt: String,

        val startAt: String,

        val endAt: String,

        val lastActivityAt: String,

        val lastAttendedAt: String? = null,

        val totalActivityTime: Int,

        val htmlUrl: String,

        val grades: Grades,

        val user: UserEntity,

        val overrideGrade: String? = null,

        val overrideScore: Double? = null,

        val unpostedCurrentGrade: String? = null,

        val unpostedFinalGrade: String? = null,

        val unpostedCurrentScore: Double? = null,

        val unpostedFinalScore: Double? = null,

        val hasGradingPeriods: Boolean? = null,

        val totalsForAllGradingPeriodsOption: Boolean? = null,

        val currentGradingPeriodTitle: String? = null,

        val currentGradingPeriodId: Int? = null,

        val currentPeriodOverrideGrade: String? = null,

        val currentPeriodOverrideScore: Double? = null,

        val currentPeriodUnpostedCurrentScore: Double? = null,

        val currentPeriodUnpostedFinalScore: Double? = null,

        val currentPeriodUnpostedCurrentGrade: String? = null,

        val currentPeriodUnpostedFinalGrade: String? = null
) {
    @Serializable
    data class Grades(
        val htmlUrl: String,

        val currentScore: Double? = null,

        val currentGrade: String? = null,

        val finalScore: Double? = null,

        val finalGrade: String? = null

    )

    @Serializable
    data class User(
        val id: Int,

        val name: String,

        val sortableName: String,

        val shortName: String
    )
}

fun EnrollmentEntity.translate(): Enrollment {
    return Enrollment(
        id = id,
        courseId = courseId,
        sisCourseId = sisCourseId,
        courseIntegrationId = courseIntegrationId,
        courseSectionId = courseSectionId,
        sectionIntegrationId = sectionIntegrationId,
        sisAccountId = sisAccountId,
        sisSectionId = sisSectionId,
        sisUserId = sisUserId,
        enrollmentState = enrollmentState,
        limitPrivilegesToCourseSection = limitPrivilegesToCourseSection,
        sisImportId = sisImportId,
        rootAccountId = rootAccountId,
        type = type,
        userId = userId,
        associatedUserId = associatedUserId,
        role = role,
        roleId = roleId,
        createdAt = createdAt,
        updatedAt = updatedAt,
        startAt = startAt,
        endAt = endAt,
        lastActivityAt = lastActivityAt,
        lastAttendedAt = lastAttendedAt,
        totalActivityTime = totalActivityTime,
        htmlUrl = htmlUrl,
        grades = grades,
        user = user,
        overrideGrade = overrideGrade,
        overrideScore = overrideScore,
        unpostedCurrentGrade = unpostedCurrentGrade,
        unpostedFinalGrade = unpostedFinalGrade,
        unpostedCurrentScore = unpostedCurrentScore,
        unpostedFinalScore = unpostedFinalScore,
        hasGradingPeriods = hasGradingPeriods,
        totalsForAllGradingPeriodsOption = totalsForAllGradingPeriodsOption,
        currentGradingPeriodTitle = currentGradingPeriodTitle,
        currentGradingPeriodId = currentGradingPeriodId,
        currentPeriodOverrideGrade = currentPeriodOverrideGrade,
        currentPeriodOverrideScore = currentPeriodOverrideScore,
        currentPeriodUnpostedCurrentScore = currentPeriodUnpostedCurrentScore,
        currentPeriodUnpostedFinalScore = currentPeriodUnpostedFinalScore,
        currentPeriodUnpostedCurrentGrade = currentPeriodUnpostedCurrentGrade,
        htmlUrl = htmlUrl,
        currentScore = currentScore,
        currentGrade = currentGrade,
        finalScore = finalScore,
        id = id,
        name = name,
        sortableName = sortableName
    )
}
