package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultipleAttemptsSettingsEntity(
    // Whether to allow multiple attempts
    @SerialName("multiple_attempts_enabled")
    val multipleAttemptsEnabled: Boolean,

    // Whether to limit the number of attempts
    @SerialName("attempt_limit")
    val attemptLimit: Boolean,

    // Number of attempts to allow
    @SerialName("max_attempts")
    val maxAttempts: Int? = null,

    // Specifies which score to keep
    @SerialName("score_to_keep")
    val scoreToKeep: String,

    // Whether to enforce a waiting period after an attempt
    @SerialName("cooling_period")
    val coolingPeriod: Boolean,

    // Required waiting period (in seconds)
    @SerialName("cooling_period_seconds")
    val coolingPeriodSeconds: Int? = null
)
