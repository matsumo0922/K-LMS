package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalFeed(
        val id: Int,
        val displayName: String,
        val url: String,
        val headerMatch: String?,
        val createdAt: String,
        val verbosity: String
)

fun ExternalFeedEntity.translate(): ExternalFeed {
    return ExternalFeed(
        id = id,
        displayName = displayName,
        url = url,
        headerMatch = headerMatch,
        createdAt = createdAt
    )
}
