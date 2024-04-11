package me.matsumo.klms.core.model.entity

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.EntryEntity

@Serializable
data class StimulusItem(
        val title: String,

        val body: String,

        val instructions: String? = null,

        val sourceUrl: String? = null,

        val orientation: String
) : EntryEntity

fun StimulusItemEntity.translate(): StimulusItem {
    return StimulusItem(
        title = title,
        body = body,
        instructions = instructions,
        sourceUrl = sourceUrl
    )
}
