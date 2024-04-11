package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ScoreStatistic(
        val min: Int,
        val max: Int,
        val mean: Int,
        val upperQ: Int,
        val median: Int,
        val lowerQ: Int
)

fun ScoreStatisticEntity.translate(): ScoreStatistic {
    return ScoreStatistic(
        min = min,
        max = max,
        mean = mean,
        upperQ = upperQ,
        median = median
    )
}
