package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.SubmissionVersionEntity

@Serializable
data class SubmissionVersion(
    val assignmentId: Int,

    val assignmentName: String,

    val body: String,

    val currentGrade: String,

    val currentGradedAt: String,

    val currentGrader: String,

    val gradeMatchesCurrentSubmission: Boolean,

    val gradedAt: String,

    val grader: String,

    val graderId: Int,

    val id: Int,

    val newGrade: String,

    val newGradedAt: String,

    val newGrader: String,

    val previousGrade: String? = null, 
    val previousGradedAt: String? = null, 
    val previousGrader: String? = null, 
    val score: Double, 
    val userName: String,

    val submissionType: String,

    val url: String? = null,

    val userId: Int,

    val workflowState: String
)

fun SubmissionVersionEntity.translate(): SubmissionVersion {
    return SubmissionVersion(
        assignmentId = assignmentId,
        assignmentName = assignmentName,
        body = body,
        currentGrade = currentGrade,
        currentGradedAt = currentGradedAt,
        currentGrader = currentGrader,
        gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission,
        gradedAt = gradedAt,
        grader = grader,
        graderId = graderId,
        id = id,
        newGrade = newGrade,
        newGradedAt = newGradedAt,
        newGrader = newGrader,
        previousGrade = previousGrade,
        previousGradedAt = previousGradedAt,
        previousGrader = previousGrader,
        score = score,
        userName = userName,
        submissionType = submissionType,
        url = url,
        userId = userId
    )
}
