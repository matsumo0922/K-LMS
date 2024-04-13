package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Used by Assignment model
@Serializable
data class ScoreStatisticEntity(
    // Min score
    @SerialName("min") val min: Int,
    // Max score
    @SerialName("max") val max: Int,
    // Mean score
    @SerialName("mean") val mean: Int,
    // Upper quartile score
    @SerialName("upper_q") val upperQ: Int,
    // Median score
    @SerialName("median") val median: Int,
    // Lower quartile score
    @SerialName("lower_q") val lowerQ: Int,
)
