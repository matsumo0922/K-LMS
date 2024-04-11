package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeImportData(
        val importType: String
)

fun OutcomeImportDataEntity.translate(): OutcomeImportData {
    return OutcomeImportData(
        
    )
}
