package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizSettingsEntity

@Serializable
data class QuizSettings(
        val calculatorType: String,

        val filterIpAddress: Boolean,

        val oneAtATimeType: Instant,

        val allowBacktracking: Boolean,

        val shuffleAnswers: Boolean,

        val shuffleQuestions: Boolean,

        val requireStudentAccessCode: Boolean,

        val studentAccessCode: String? = null,

        val hasTimeLimit: Boolean,

        val sessionTimeLimitInSeconds: Int? = null,

        val multipleAttempts: MultipleAttemptsSettingsEntity? = null,

        val resultViewSettings: ResultViewSettingsEntity? = null
)


fun QuizSettingsEntity.translate(): QuizSettings {
    return QuizSettings(
        calculatorType = calculatorType,
        filterIpAddress = filterIpAddress,
        oneAtATimeType = Instant.parse(oneAtATimeType),
        allowBacktracking = allowBacktracking,
        shuffleAnswers = shuffleAnswers,
        shuffleQuestions = shuffleQuestions,
        requireStudentAccessCode = requireStudentAccessCode,
        studentAccessCode = studentAccessCode,
        hasTimeLimit = hasTimeLimit,
        sessionTimeLimitInSeconds = sessionTimeLimitInSeconds,
        multipleAttempts = multipleAttempts
    )
}
