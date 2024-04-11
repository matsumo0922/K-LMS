package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSettingsEntity(
    // Type of calculator
    @SerialName("calculator_type")
    val calculatorType: String,

    // Whether to restrict access by IP address
    @SerialName("filter_ip_address")
    val filterIpAddress: Boolean,

    // How questions are shown
    @SerialName("one_at_a_time_type")
    val oneAtATimeType: String,

    // Whether to allow going back to previous questions
    @SerialName("allow_backtracking")
    val allowBacktracking: Boolean,

    // Shuffle answers
    @SerialName("shuffle_answers")
    val shuffleAnswers: Boolean,

    // Shuffle questions
    @SerialName("shuffle_questions")
    val shuffleQuestions: Boolean,

    // Whether to require an access code
    @SerialName("require_student_access_code")
    val requireStudentAccessCode: Boolean,

    // Access code
    @SerialName("student_access_code")
    val studentAccessCode: String? = null,

    // Whether there's a time limit
    @SerialName("has_time_limit")
    val hasTimeLimit: Boolean,

    // Time limit in seconds
    @SerialName("session_time_limit_in_seconds")
    val sessionTimeLimitInSeconds: Int? = null,

    // Multiple attempts settings
    @SerialName("multiple_attempts")
    val multipleAttempts: me.matsumo.klms.core.model.lms.entity.MultipleAttemptsSettingsEntity? = null,

    // Result viewing settings
    @SerialName("result_view_settings")
    val resultViewSettings: me.matsumo.klms.core.model.lms.entity.ResultViewSettingsEntity? = null
)

// You'll have the 'MultipleAttemptsSettings' and 'ResultViewSettings'
// classes from previous examples.
