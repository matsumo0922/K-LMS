package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.SubmissionVersionEntity

@Serializable
data class SubmissionVersion(
    val assignmentId: Int,
    val assignmentName: String,
    val body: String,
    val currentGrade: String,
    val currentGradedAt: Instant,
    val currentGrader: String,
    val gradeMatchesCurrentSubmission: Boolean,
    val gradedAt: Instant,
    val grader: String,
    val graderId: Int,
    val id: Int,
    val newGrade: String,
    val newGradedAt: Instant,
    val newGrader: String,
    val previousGrade: String? = null,
    val previousGradedAt: Instant? = null,
    val previousGrader: String? = null,
    val score: Double,
    val userName: String,
    val submissionType: String,
    val url: String? = null,
    val userId: Int,
    val workflowState: String,
)

fun SubmissionVersionEntity.translate(): SubmissionVersion {
    return SubmissionVersion(
        assignmentId = assignmentId,
        assignmentName = assignmentName,
        body = body,
        currentGrade = currentGrade,
        currentGradedAt = Instant.parse(currentGradedAt),
        currentGrader = currentGrader,
        gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission,
        gradedAt = Instant.parse(gradedAt),
        grader = grader,
        graderId = graderId,
        id = id,
        newGrade = newGrade,
        newGradedAt = Instant.parse(newGradedAt),
        newGrader = newGrader,
        previousGrade = previousGrade,
        previousGradedAt = previousGradedAt?.let { Instant.parse(it) },
        previousGrader = previousGrader,
        score = score,
        userName = userName,
        submissionType = submissionType,
        url = url,
        userId = userId,
        workflowState = workflowState,
    )
}
