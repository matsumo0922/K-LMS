package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSubmissionEntity(
    // The ID of the quiz submission.
    @SerialName("id")
    val id: Int,

    // The ID of the Quiz
    @SerialName("quiz_id")
    val quizId: Int,

    // The ID of the Student
    @SerialName("user_id")
    val userId: Int,

    // The ID of the Submission it represents
    @SerialName("submission_id")
    val submissionId: Int,

    // Time the student started the quiz submission
    @SerialName("started_at")
    val startedAt: String,

    // Time the student finished the quiz submission
    @SerialName("finished_at")
    val finishedAt: String,

    //  Submission deadline
    @SerialName("end_at")
    val endAt: String,

    // The attempt number
    @SerialName("attempt")
    val attempt: Int,

    // Number of extra attempts allowed
    @SerialName("extra_attempts")
    val extraAttempts: Int,

    //  Extra time allowed (in minutes)
    @SerialName("extra_time")
    val extraTime: Int,

    // Whether the submission was manually unlocked
    @SerialName("manually_unlocked")
    val manuallyUnlocked: Boolean,

    // Time spent on the submission (in seconds)
    @SerialName("time_spent")
    val timeSpent: Int,

    //  Score of the quiz submission
    @SerialName("score")
    val score: Double?,

    // Score before any re-grading
    @SerialName("score_before_regrade")
    val scoreBeforeRegrade: Double?,

    // Kept score for multiple attempts
    @SerialName("kept_score")
    val keptScore: Double?,

    // Fudge points
    @SerialName("fudge_points")
    val fudgePoints: Int,

    // Whether the student has seen results
    @SerialName("has_seen_results")
    val hasSeenResults: Boolean,

    //  Current state of the quiz submission
    @SerialName("workflow_state")
    val workflowState: String,

    //  Whether the submission is overdue
    @SerialName("overdue_and_needs_submission")
    val overdueAndNeedsSubmission: Boolean
)
