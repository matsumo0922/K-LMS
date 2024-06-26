package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizSubmissionEntity

@Serializable
data class QuizSubmission(
    val id: Int,
    val quizId: Int,
    val userId: Int,
    val submissionId: Int,
    val startedAt: Instant,
    val finishedAt: Instant,
    val endAt: Instant,
    val attempt: Int,
    val extraAttempts: Int,
    val extraTime: Int,
    val manuallyUnlocked: Boolean,
    val timeSpent: Int,
    val score: Double?,
    val scoreBeforeRegrade: Double?,
    val keptScore: Double?,
    val fudgePoints: Int,
    val hasSeenResults: Boolean,
    val workflowState: String,
    val overdueAndNeedsSubmission: Boolean,
)

fun QuizSubmissionEntity.translate(): QuizSubmission {
    return QuizSubmission(
        id = id,
        quizId = quizId,
        userId = userId,
        submissionId = submissionId,
        startedAt = Instant.parse(startedAt),
        finishedAt = Instant.parse(finishedAt),
        endAt = Instant.parse(endAt),
        attempt = attempt,
        extraAttempts = extraAttempts,
        extraTime = extraTime,
        manuallyUnlocked = manuallyUnlocked,
        timeSpent = timeSpent,
        score = score,
        scoreBeforeRegrade = scoreBeforeRegrade,
        keptScore = keptScore,
        fudgePoints = fudgePoints,
        hasSeenResults = hasSeenResults,
        workflowState = workflowState,
        overdueAndNeedsSubmission = overdueAndNeedsSubmission,
    )
}
