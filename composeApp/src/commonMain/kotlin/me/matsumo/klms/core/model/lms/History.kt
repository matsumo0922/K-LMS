package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class History(
        val assetCode: String,

        val assetName: String,

        val assetIcon: String,

        val assetReadableCategory: String,

        val contextType: String,

        val contextId: Int,

        val contextName: String,

        val visitedUrl: String,

        val visitedAt: String,

        val interactionSeconds: Int
)

fun HistoryEntity.translate(): History {
    return History(
        assetCode = assetCode,
        assetName = assetName,
        assetIcon = assetIcon,
        assetReadableCategory = assetReadableCategory,
        contextType = contextType,
        contextId = contextId,
        contextName = contextName,
        visitedUrl = visitedUrl,
        visitedAt = visitedAt
    )
}
