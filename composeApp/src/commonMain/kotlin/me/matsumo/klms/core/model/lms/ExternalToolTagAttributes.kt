package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExternalToolTagAttributes(
        val url: String,
        val newTab: Boolean,
        val resourceLinkId: String
)

fun ExternalToolTagAttributesEntity.translate(): ExternalToolTagAttributes {
    return ExternalToolTagAttributes(
        url = url,
        newTab = newTab
    )
}
