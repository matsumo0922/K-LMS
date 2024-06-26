package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssignmentEntity
import me.matsumo.klms.core.model.lms.entity.LockInfoEntity
import me.matsumo.klms.core.model.lms.entity.RubricCriteriaEntity
import me.matsumo.klms.core.model.lms.entity.TurnitinSettingsEntity

@Serializable
data class Assignment(
    val id: Int,
    val name: String,
    val description: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val dueAt: Instant?,
    val lockAt: Instant?,
    val unlockAt: Instant?,
    val hasOverrides: Boolean,
    val courseId: Int,
    val htmlUrl: String,
    val submissionsDownloadUrl: String,
    val assignmentGroupId: Int,
    val dueDateRequired: Boolean,
    val allowedExtensions: List<String>?,
    val maxNameLength: Int,
    val turnitinEnabled: Boolean,
    val vericiteEnabled: Boolean,
    val gradeGroupStudentsIndividually: Boolean,
    val peerReviews: Boolean,
    val automaticPeerReviews: Boolean,
    val peerReviewCount: Int?,
    val peerReviewsAssignAt: Instant?,
    val intraGroupPeerReviews: Boolean,
    val groupCategoryId: Int?,
    val needsGradingCount: Int,
    val position: Int,
    val pointsPossible: Double,
    val submissionTypes: List<String>,
    val published: Boolean,
    val unpublishable: Boolean,
    val onlyVisibleToOverrides: Boolean,
    val lockedForUser: Boolean,
    val lockExplanation: String?,
    val useRubricForGrading: Boolean?,
    val moderatedGrading: Boolean,
    val graderCount: Int,
    val finalGraderId: Int?,
    val graderCommentsVisibleToGraders: Boolean,
    val anonymousGrading: Boolean,
    val allowedAttempts: Int,
    val postManually: Boolean,
    val omitFromFinalGrade: Boolean?,
    val anonymousPeerReviews: Boolean,
    val anonymousInstructorAnnotations: Boolean,
    val gradedSubmissionsExist: Boolean,
    val workflowState: String,
    val allDates: List<AssignmentDate>?,
    val externalToolTagAttributes: ExternalToolTagAttributes?,
    val canSubmit: Boolean?,
    val turnitinSettings: TurnitinSettingsEntity?,
    val needsGradingCountBySection: List<NeedsGradingCount>?,
    val rubric: List<RubricCriteriaEntity>?,
    val assignmentVisibility: List<Int>?,
    val overrides: List<AssignmentOverride>?,
    val lockInfo: LockInfoEntity?,
    val discussionTopic: DiscussionTopic?,
    val frozenAttributes: List<String>?,
    val scoreStatistics: ScoreStatistic?,
    val abGuid: List<String>?,
    val annotatableAttachmentId: Int?,
    val anonymizeStudents: Boolean?,
    val requireLockdownBrowser: Boolean?,
    val importantDates: Boolean?,
    val muted: Boolean?,
    val isQuizAssignment: Boolean?,
    val inClosedGradingPeriod: Boolean?,
    val canDuplicate: Boolean?,
    val originalCourseId: Int?,
    val originalAssignmentId: Int?,
    val originalLtiResourceLinkId: Int?,
    val originalAssignmentName: String?,
    val originalQuizId: Int?,
    val integrationId: String?,
    val integrationData: Map<String, String>?,
)

fun AssignmentEntity.translate(): Assignment {
    return Assignment(
        id = id,
        name = name,
        description = description,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        dueAt = dueAt?.let { Instant.parse(it) },
        lockAt = lockAt?.let { Instant.parse(it) },
        unlockAt = unlockAt?.let { Instant.parse(it) },
        hasOverrides = hasOverrides,
        courseId = courseId,
        htmlUrl = htmlUrl,
        submissionsDownloadUrl = submissionsDownloadUrl,
        assignmentGroupId = assignmentGroupId,
        dueDateRequired = dueDateRequired,
        allowedExtensions = allowedExtensions,
        maxNameLength = maxNameLength,
        turnitinEnabled = turnitinEnabled,
        vericiteEnabled = vericiteEnabled,
        gradeGroupStudentsIndividually = gradeGroupStudentsIndividually,
        peerReviews = peerReviews,
        automaticPeerReviews = automaticPeerReviews,
        peerReviewCount = peerReviewCount,
        peerReviewsAssignAt = peerReviewsAssignAt?.let { Instant.parse(it) },
        intraGroupPeerReviews = intraGroupPeerReviews,
        groupCategoryId = groupCategoryId,
        needsGradingCount = needsGradingCount,
        position = position,
        pointsPossible = pointsPossible,
        submissionTypes = submissionTypes,
        published = published,
        unpublishable = unpublishable,
        onlyVisibleToOverrides = onlyVisibleToOverrides,
        lockedForUser = lockedForUser,
        lockExplanation = lockExplanation,
        useRubricForGrading = useRubricForGrading,
        moderatedGrading = moderatedGrading,
        graderCount = graderCount,
        finalGraderId = finalGraderId,
        graderCommentsVisibleToGraders = graderCommentsVisibleToGraders,
        anonymousGrading = anonymousGrading,
        allowedAttempts = allowedAttempts,
        postManually = postManually,
        omitFromFinalGrade = omitFromFinalGrade,
        anonymousPeerReviews = anonymousPeerReviews,
        anonymousInstructorAnnotations = anonymousInstructorAnnotations,
        gradedSubmissionsExist = gradedSubmissionsExist,
        workflowState = workflowState,
        allDates = allDates?.map { it.translate() },
        externalToolTagAttributes = externalToolTagAttributes?.translate(),
        canSubmit = canSubmit,
        turnitinSettings = turnitinSettings,
        needsGradingCountBySection = needsGradingCountBySection?.map { it.translate() },
        rubric = rubric,
        assignmentVisibility = assignmentVisibility,
        overrides = overrides?.map { it.translate() },
        lockInfo = lockInfo,
        discussionTopic = discussionTopic?.translate(),
        frozenAttributes = frozenAttributes,
        scoreStatistics = scoreStatistics?.translate(),
        abGuid = abGuid,
        annotatableAttachmentId = annotatableAttachmentId,
        anonymizeStudents = anonymizeStudents,
        requireLockdownBrowser = requireLockdownBrowser,
        importantDates = importantDates,
        muted = muted,
        isQuizAssignment = isQuizAssignment,
        inClosedGradingPeriod = inClosedGradingPeriod,
        canDuplicate = canDuplicate,
        originalCourseId = originalCourseId,
        originalAssignmentId = originalAssignmentId,
        originalLtiResourceLinkId = originalLtiResourceLinkId,
        originalAssignmentName = originalAssignmentName,
        originalQuizId = originalQuizId,
        integrationId = integrationId,
        integrationData = integrationData,
    )
}
