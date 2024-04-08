package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalToolTagAttributesEntity(
    // URL to the external tool
    @SerialName("url") val url: String,
    // Whether or not there is a new tab for the external tool
    @SerialName("new_tab") val newTab: Boolean,
    // the identifier for this tool_tag
    @SerialName("resource_link_id") val resourceLinkId: String
)
