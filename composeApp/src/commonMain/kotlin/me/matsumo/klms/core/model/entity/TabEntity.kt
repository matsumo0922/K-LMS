package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TabEntity(
    // The HTML URL of the tab
    @SerialName("html_url")
    val htmlUrl: String,

    // Unique identifier for the tab
    @SerialName("id")
    val id: String,

    // The displayed label of the tab
    @SerialName("label")
    val label: String,

    // Type of tab
    @SerialName("type")
    val type: String,

    // Visibility of the tab (sometimes included)
    @SerialName("visibility")
    val visibility: String? ,

    // Whether the tab is hidden (sometimes included)
    @SerialName("hidden")
    val hidden: Boolean?,

    @SerialName("position")
    val position: Int
)
