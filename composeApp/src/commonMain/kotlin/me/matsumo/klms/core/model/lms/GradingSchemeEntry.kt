package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingSchemeEntry(
        val name: String,

        val value: Double
)

fun GradingSchemeEntryEntity.translate(): GradingSchemeEntry {
    return GradingSchemeEntry(
        name = name
    )
}
