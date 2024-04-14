package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.HistoryEntity

@Serializable
data class LmsHistory(
    val assetCode: String,
    val assetName: String,
    val assetIcon: String,
    val assetReadableCategory: String,
    val contextType: String,
    val contextId: Int,
    val contextName: String,
    val visitedUrl: String,
    val visitedAt: Instant,
    val interactionSeconds: Int,
)

fun HistoryEntity.translate(): LmsHistory {
    return LmsHistory(
        assetCode = assetCode,
        assetName = assetName,
        assetIcon = assetIcon,
        assetReadableCategory = assetReadableCategory,
        contextType = contextType,
        contextId = contextId,
        contextName = contextName,
        visitedUrl = visitedUrl,
        visitedAt = Instant.parse(visitedAt),
        interactionSeconds = interactionSeconds,
    )
}
