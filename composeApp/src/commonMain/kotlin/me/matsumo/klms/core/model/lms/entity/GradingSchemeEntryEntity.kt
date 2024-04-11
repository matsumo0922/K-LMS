package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingSchemeEntryEntity(
    // The name for an entry value within a GradingStandard ...
    @SerialName("name")
    val name: String,

    // The value for the name of the entry within a GradingStandard ...
    @SerialName("value")
    val value: Double
)
