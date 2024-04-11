package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Submission(
        val assignmentId: Int,

        val assignment: AssignmentEntity?,

        val course: CourseEntity?,

        val attempt: Int,

        val body: String?,

        val grade: String?,

        val gradeMatchesCurrentSubmission: Boolean,

        val htmlUrl: String,

        val previewUrl: String,

        val score: Double?,

        val submissionComments: List<SubmissionCommentEntity>?,

        val submissionType: String,

        val submittedAt: String,

        val url: String?,

        val userId: Int,

        val graderId: Int,

        val gradedAt: String?,

        val user: UserEntity?,

        val late: Boolean,

        val assignmentVisible: Boolean,

        val excused: Boolean,

        val missing: Boolean,

        val latePolicyStatus: String?,

        val pointsDeducted: Double?,

        val secondsLate: Int?,

        val workflowState: String,

        val extraAttempts: Int,

        val anonymousId: String?,

        val postedAt: String?,

        val readStatus: String?,

        val redoRequest: Boolean
)

fun SubmissionEntity.translate(): Submission {
    return Submission(
        assignmentId = assignmentId,
        assignment = assignment,
        course = course,
        attempt = attempt,
        body = body,
        grade = grade,
        gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission,
        htmlUrl = htmlUrl,
        previewUrl = previewUrl,
        score = score,
        submissionComments = submissionComments,
        submissionType = submissionType,
        submittedAt = submittedAt,
        url = url,
        userId = userId,
        graderId = graderId,
        gradedAt = gradedAt,
        user = user,
        late = late,
        assignmentVisible = assignmentVisible,
        excused = excused,
        missing = missing,
        latePolicyStatus = latePolicyStatus,
        pointsDeducted = pointsDeducted,
        secondsLate = secondsLate,
        workflowState = workflowState,
        extraAttempts = extraAttempts,
        anonymousId = anonymousId,
        postedAt = postedAt,
        readStatus = readStatus
    )
}
