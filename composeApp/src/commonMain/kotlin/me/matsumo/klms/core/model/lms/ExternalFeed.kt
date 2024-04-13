package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ExternalFeedEntity

@Serializable
data class ExternalFeed(
    val id: Int,
    val displayName: String,
    val url: String,
    val headerMatch: String?,
    val createdAt: String,
    val verbosity: String,
)

fun ExternalFeedEntity.translate(): ExternalFeed {
    return ExternalFeed(
        id = id,
        displayName = displayName,
        url = url,
        headerMatch = headerMatch,
        createdAt = createdAt,
        verbosity = verbosity,
    )
}
