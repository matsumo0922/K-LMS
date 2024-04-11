package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultipleAttemptsSettings(
        val multipleAttemptsEnabled: Boolean,

        val attemptLimit: Boolean,

        val maxAttempts: Int? = null,

        val scoreToKeep: String,

        val coolingPeriod: Boolean,

        val coolingPeriodSeconds: Int? = null
)

fun MultipleAttemptsSettingsEntity.translate(): MultipleAttemptsSettings {
    return MultipleAttemptsSettings(
        multipleAttemptsEnabled = multipleAttemptsEnabled,
        attemptLimit = attemptLimit,
        maxAttempts = maxAttempts,
        scoreToKeep = scoreToKeep,
        coolingPeriod = coolingPeriod
    )
}
