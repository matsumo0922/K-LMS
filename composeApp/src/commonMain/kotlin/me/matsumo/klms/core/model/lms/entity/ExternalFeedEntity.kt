package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalFeedEntity(
    // The ID of the feed
    @SerialName("id") val id: Int,
    // The title of the feed, pulled from the feed itself. If the feed hasn't yet been pulled, a temporary name will be synthesized based on the URL
    @SerialName("display_name") val displayName: String,
    // The HTTP/HTTPS URL to the feed
    @SerialName("url") val url: String,
    // If not null, only feed entries whose title contains this string will trigger new posts in Canvas
    @SerialName("header_match") val headerMatch: String?,
    // When this external feed was added to Canvas
    @SerialName("created_at") val createdAt: String,
    // The verbosity setting determines how much of the feed's content is imported into Canvas as part of the posting. 'link_only' means that only the title and a link to the item. 'truncate' means that a summary of the first portion of the item body will be used. 'full' means that the full item body will be used.
    @SerialName("verbosity") val verbosity: String
)
