package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradingSchemeEntryEntity

@Serializable
data class GradingSchemeEntry(
    val name: String,
    val value: Double,
)

fun GradingSchemeEntryEntity.translate(): GradingSchemeEntry {
    return GradingSchemeEntry(
        name = name,
        value = value,
    )
}
