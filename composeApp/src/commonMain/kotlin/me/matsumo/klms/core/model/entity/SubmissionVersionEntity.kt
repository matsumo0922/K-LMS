package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionVersionEntity(
    @SerialName("assignment_id")
    val assignmentId: Int,

    @SerialName("assignment_name")
    val assignmentName: String,

    @SerialName("body")
    val body: String,

    @SerialName("current_grade")
    val currentGrade: String,

    @SerialName("current_graded_at")
    val currentGradedAt: String,

    @SerialName("current_grader")
    val currentGrader: String,

    @SerialName("grade_matches_current_submission")
    val gradeMatchesCurrentSubmission: Boolean,

    @SerialName("graded_at")
    val gradedAt: String,

    @SerialName("grader")
    val grader: String,

    @SerialName("grader_id")
    val graderId: Int,

    @SerialName("id")
    val id: Int,

    @SerialName("new_grade")
    val newGrade: String,

    @SerialName("new_graded_at")
    val newGradedAt: String,

    @SerialName("new_grader")
    val newGrader: String,

    @SerialName("previous_grade")
    val previousGrade: String? = null, // Optional

    @SerialName("previous_graded_at")
    val previousGradedAt: String? = null, // Optional

    @SerialName("previous_grader")
    val previousGrader: String? = null, // Optional

    @SerialName("score")
    val score: Double, // Using double for scores

    @SerialName("user_name")
    val userName: String,

    @SerialName("submission_type")
    val submissionType: String,

    @SerialName("url")
    val url: String? = null,

    @SerialName("user_id")
    val userId: Int,

    @SerialName("workflow_state")
    val workflowState: String
)
