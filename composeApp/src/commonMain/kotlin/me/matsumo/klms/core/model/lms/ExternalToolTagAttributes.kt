package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ExternalToolTagAttributesEntity

@Serializable
data class ExternalToolTagAttributes(
    val url: String,
    val newTab: Boolean,
    val resourceLinkId: String,
)

fun ExternalToolTagAttributesEntity.translate(): ExternalToolTagAttributes {
    return ExternalToolTagAttributes(
        url = url,
        newTab = newTab,
        resourceLinkId = resourceLinkId,
    )
}
