package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ScoreStatisticEntity

@Serializable
data class ScoreStatistic(
    val min: Int,
    val max: Int,
    val mean: Int,
    val upperQ: Int,
    val median: Int,
    val lowerQ: Int,
)

fun ScoreStatisticEntity.translate(): ScoreStatistic {
    return ScoreStatistic(
        min = min,
        max = max,
        mean = mean,
        upperQ = upperQ,
        median = median,
        lowerQ = lowerQ,
    )
}
