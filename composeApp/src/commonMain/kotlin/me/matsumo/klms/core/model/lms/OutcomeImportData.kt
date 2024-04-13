package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeImportDataEntity

@Serializable
data class OutcomeImportData(
    val importType: String,
)

fun OutcomeImportDataEntity.translate(): OutcomeImportData {
    return OutcomeImportData(
        importType = importType,
    )
}
