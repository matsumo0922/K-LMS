package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.NeedsGradingCountEntity

@Serializable
data class NeedsGradingCount(
    val sectionId: String,
    val needsGradingCount: Int,
)

fun NeedsGradingCountEntity.translate(): NeedsGradingCount {
    return NeedsGradingCount(
        sectionId = sectionId,
        needsGradingCount = needsGradingCount,
    )
}
