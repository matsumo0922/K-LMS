package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizEntity(
    // The ID of the quiz
    @SerialName("id")
    val id: Int,

    // The title of the quiz
    @SerialName("title")
    val title: String,

    // The HTTP/HTTPS URL to the quiz
    @SerialName("html_url")
    val htmlUrl: String,

    // URL for loading in a mobile webview
    @SerialName("mobile_url")
    val mobileUrl: String,

    // URL for teacher preview
    @SerialName("preview_url")
    val previewUrl: String?,

    // The description of the quiz
    @SerialName("description")
    val description: String?,

    // Type of quiz
    @SerialName("quiz_type")
    val quizType: String,

    // The ID of the assignment group
    @SerialName("assignment_group_id")
    val assignmentGroupId: Int,

    // Time limit in minutes
    @SerialName("time_limit")
    val timeLimit: Int?, // Assuming time limit is optional

    // Shuffle answers?
    @SerialName("shuffle_answers")
    val shuffleAnswers: Boolean,

    // When to show results to students
    @SerialName("hide_results")
    val hideResults: String?,

    // Show correct answers?
    @SerialName("show_correct_answers")
    val showCorrectAnswers: Boolean,

    // Show correct answers only after last attempt?
    @SerialName("show_correct_answers_last_attempt")
    val showCorrectAnswersLastAttempt: Boolean,

    // When are correct answers visible?
    @SerialName("show_correct_answers_at")
    val showCorrectAnswersAt: String?,

    // Hide correct answers after this date?
    @SerialName("hide_correct_answers_at")
    val hideCorrectAnswersAt: String?,

    // Can students view their results only once?
    @SerialName("one_time_results")
    val oneTimeResults: Boolean,

    // Which score to keep
    @SerialName("scoring_policy")
    val scoringPolicy: String,

    // Allowed attempts (-1 = unlimited)
    @SerialName("allowed_attempts")
    val allowedAttempts: Int,

    // Show one question at a time?
    @SerialName("one_question_at_a_time")
    val oneQuestionAtATime: Boolean,

    // Number of questions in the quiz
    @SerialName("question_count")
    val questionCount: Int,

    // Total points possible
    @SerialName("points_possible")
    val pointsPossible: Int,

    // Can't go back after answering?
    @SerialName("cant_go_back")
    val cantGoBack: Boolean,

    // Access code
    @SerialName("access_code")
    val accessCode: String?,

    // IP filter
    @SerialName("ip_filter")
    val ipFilter: String?,

    // Due date
    @SerialName("due_at")
    val dueAt: String?,

    // Lock date
    @SerialName("lock_at")
    val lockAt: String?,

    // Unlock date
    @SerialName("unlock_at")
    val unlockAt: String?,

    // Published state
    @SerialName("published")
    val published: Boolean,

    // Can 'published' state be changed to false?
    @SerialName("unpublishable")
    val unpublishable: Boolean,

    // Locked for the user?
    @SerialName("locked_for_user")
    val lockedForUser: Boolean,

    // Lock information (optional)
    @SerialName("lock_info")
    val lockInfo: me.matsumo.klms.core.model.lms.entity.LockInfoEntity?,

    // Lock explanation (optional)
    @SerialName("lock_explanation")
    val lockExplanation: String?,

    // SpeedGrader URL (if published)
    @SerialName("speedgrader_url")
    val speedgraderUrl: String?,

    // API endpoint for quiz extensions
    @SerialName("quiz_extensions_url")
    val quizExtensionsUrl: String,

    // User permissions
    @SerialName("permissions")
    val permissions: me.matsumo.klms.core.model.lms.entity.QuizPermissionsEntity?,

    // List of due dates
    @SerialName("all_dates")
    val allDates: List<String>?, // Assuming list of due dates

    // Quiz version number
    @SerialName("version_number")
    val versionNumber: Int,

    // List of question types in the quiz
    @SerialName("question_types")
    val questionTypes: List<String>,

    // Anonymous submissions for surveys?
    @SerialName("anonymous_submissions")
    val anonymousSubmissions: Boolean
)
