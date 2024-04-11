package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tab(
        val htmlUrl: String,

        val id: String,

        val label: String,

        val type: String,

        val visibility: String? ,

        val hidden: Boolean?,

    val position: Int
)

fun TabEntity.translate(): Tab {
    return Tab(
        htmlUrl = htmlUrl,
        id = id,
        label = label,
        type = type,
        visibility = visibility,
        hidden = hidden
    )
}
