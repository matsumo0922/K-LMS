package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionEntity(
    // The assignment ID
    @SerialName("assignment_id")
    val assignmentId: Int,

    // The assignment (optional)
    @SerialName("assignment")
    val assignment: AssignmentEntity?,

    //  The course (optional)
    @SerialName("course")
    val course: CourseEntity?,

    // Submission attempt number
    @SerialName("attempt")
    val attempt: Int,

    // Text content of the submission
    @SerialName("body")
    val body: String?,

    // Grade in the assignment's grading scheme
    @SerialName("grade")
    val grade: String?,

    // Flag indicating if the grade matches the current submission
    @SerialName("grade_matches_current_submission")
    val gradeMatchesCurrentSubmission: Boolean,

    // URL to view the submission
    @SerialName("html_url")
    val htmlUrl: String,

    // URL to preview the submission
    @SerialName("preview_url")
    val previewUrl: String,

    // The raw score
    @SerialName("score")
    val score: Double?,

    // Associated comments (optional)
    @SerialName("submission_comments")
    val submissionComments: List<SubmissionCommentEntity>?,

    // Submission type
    @SerialName("submission_type")
    val submissionType: String,

    // Submission timestamp
    @SerialName("submitted_at")
    val submittedAt: String,

    // URL for online_url submissions
    @SerialName("url")
    val url: String?,

    // ID of the submitting user
    @SerialName("user_id")
    val userId: Int,

    //  ID of the grading user
    @SerialName("grader_id")
    val graderId: Int,

    // Time the submission was graded
    @SerialName("graded_at")
    val gradedAt: String?,

    // The submitting user (optional)
    @SerialName("user")
    val user: UserEntity?,

    // Whether the submission was late
    @SerialName("late")
    val late: Boolean,

    // Whether the assignment is visible to the student
    @SerialName("assignment_visible")
    val assignmentVisible: Boolean,

    // Whether the assignment is excused
    @SerialName("excused")
    val excused: Boolean,

    // Whether the assignment is missing
    @SerialName("missing")
    val missing: Boolean,

    // Late policy status
    @SerialName("late_policy_status")
    val latePolicyStatus: String?,

    // Points deducted for being late or missing
    @SerialName("points_deducted")
    val pointsDeducted: Double?,

    // Time submission was late (in seconds)
    @SerialName("seconds_late")
    val secondsLate: Int?,

    // Workflow state of the submission
    @SerialName("workflow_state")
    val workflowState: String,

    // Extra submission attempts allowed
    @SerialName("extra_attempts")
    val extraAttempts: Int,

    // Anonymous ID for the submission
    @SerialName("anonymous_id")
    val anonymousId: String?,

    // The date the submission was posted to student
    @SerialName("posted_at")
    val postedAt: String?,

    // Read status of the submission (optional)
    @SerialName("read_status")
    val readStatus: String?,

    // Whether reassignment has been requested
    @SerialName("redo_request")
    val redoRequest: Boolean
)
