package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradingRulesEntity

@Serializable
data class GradingRules(
    val dropLowest: Int,
    val dropHighest: Int,
    val neverDrop: List<Int>,
)

fun GradingRulesEntity.translate(): GradingRules {
    return GradingRules(
        dropLowest = dropLowest,
        dropHighest = dropHighest,
        neverDrop = neverDrop,
    )
}
