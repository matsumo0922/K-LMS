package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoryEntity(
    // The asset string for the item viewed
    @SerialName("asset_code")
    val assetCode: String,

    // The name of the item
    @SerialName("asset_name")
    val assetName: String,

    // The icon type shown for the item. ...
    @SerialName("asset_icon")
    val assetIcon: String,

    // The associated category describing the asset_icon
    @SerialName("asset_readable_category")
    val assetReadableCategory: String,

    // The type of context of the item visited. ...
    @SerialName("context_type")
    val contextType: String,

    // The id of the context, if applicable
    @SerialName("context_id")
    val contextId: Int,

    // The name of the context
    @SerialName("context_name")
    val contextName: String,

    // The URL of the item
    @SerialName("visited_url")
    val visitedUrl: String,

    // When the page was visited
    @SerialName("visited_at")
    val visitedAt: String,

    // The estimated time spent on the page in seconds
    @SerialName("interaction_seconds")
    val interactionSeconds: Int
)
