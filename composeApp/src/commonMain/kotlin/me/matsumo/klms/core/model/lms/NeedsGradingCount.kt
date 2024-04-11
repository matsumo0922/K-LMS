package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NeedsGradingCount(
        val sectionId: String,
        val needsGradingCount: Int
)

fun NeedsGradingCountEntity.translate(): NeedsGradingCount {
    return NeedsGradingCount(
        sectionId = sectionId
    )
}
