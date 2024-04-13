package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeImportDataEntity(
    // The type of outcome import
    @SerialName("import_type")
    val importType: String,
)
