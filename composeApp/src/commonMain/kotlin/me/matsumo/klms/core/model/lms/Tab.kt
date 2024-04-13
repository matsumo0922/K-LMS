package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.TabEntity

@Serializable
data class Tab(
    val htmlUrl: String,
    val id: String,
    val label: String,
    val type: String,
    val visibility: String?,
    val hidden: Boolean?,
    val position: Int,
)

fun TabEntity.translate(): Tab {
    return Tab(
        htmlUrl = htmlUrl,
        id = id,
        label = label,
        type = type,
        visibility = visibility,
        hidden = hidden,
        position = position,
    )
}
