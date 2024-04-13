package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.TurnitinSettingsEntity

@Serializable
data class TurnitinSettings(
    val originalityReportVisibility: String,
    val sPaperCheck: Boolean,
    val internetCheck: Boolean,
    val journalCheck: Boolean,
    val excludeBiblio: Boolean,
    val excludeQuoted: Boolean,
    val excludeSmallMatchesType: String,
    val excludeSmallMatchesValue: Int,
)

fun TurnitinSettingsEntity.translate(): TurnitinSettings {
    return TurnitinSettings(
        originalityReportVisibility = originalityReportVisibility,
        sPaperCheck = sPaperCheck,
        internetCheck = internetCheck,
        journalCheck = journalCheck,
        excludeBiblio = excludeBiblio,
        excludeQuoted = excludeQuoted,
        excludeSmallMatchesType = excludeSmallMatchesType,
        excludeSmallMatchesValue = excludeSmallMatchesValue,
    )
}
