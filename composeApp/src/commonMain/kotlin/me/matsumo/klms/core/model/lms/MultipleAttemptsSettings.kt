package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MultipleAttemptsSettingsEntity

@Serializable
data class MultipleAttemptsSettings(
    val multipleAttemptsEnabled: Boolean,
    val attemptLimit: Boolean,
    val maxAttempts: Int? = null,
    val scoreToKeep: String,
    val coolingPeriod: Boolean,
    val coolingPeriodSeconds: Int? = null,
)

fun MultipleAttemptsSettingsEntity.translate(): MultipleAttemptsSettings {
    return MultipleAttemptsSettings(
        multipleAttemptsEnabled = multipleAttemptsEnabled,
        attemptLimit = attemptLimit,
        maxAttempts = maxAttempts,
        scoreToKeep = scoreToKeep,
        coolingPeriod = coolingPeriod,
        coolingPeriodSeconds = coolingPeriodSeconds,
    )
}
