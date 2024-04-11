package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingRules(
        val dropLowest: Int,
        val dropHighest: Int,
        val neverDrop: List<Int>
)

fun GradingRulesEntity.translate(): GradingRules {
    return GradingRules(
        dropLowest = dropLowest,
        dropHighest = dropHighest
    )
}
