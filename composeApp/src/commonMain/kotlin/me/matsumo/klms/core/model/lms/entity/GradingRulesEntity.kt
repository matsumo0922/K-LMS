package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingRulesEntity(
    // Number of lowest scores to be dropped for each user.
    @SerialName("drop_lowest") val dropLowest: Int,
    // Number of highest scores to be dropped for each user.
    @SerialName("drop_highest") val dropHighest: Int,
    // Assignment IDs that should never be dropped.
    @SerialName("never_drop") val neverDrop: List<Int>
)
