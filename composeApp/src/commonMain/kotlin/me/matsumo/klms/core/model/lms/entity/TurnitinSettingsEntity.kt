package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TurnitinSettingsEntity(
    // Visibility of the originality report
    @SerialName("originality_report_visibility") val originalityReportVisibility: String,
    // Whether the student paper check is enabled
    @SerialName("s_paper_check") val sPaperCheck: Boolean,
    // Whether the internet check is enabled
    @SerialName("internet_check") val internetCheck: Boolean,
    // Whether the journal check is enabled
    @SerialName("journal_check") val journalCheck: Boolean,
    // Whether to exclude the bibliography from the originality report
    @SerialName("exclude_biblio") val excludeBiblio: Boolean,
    // Whether to exclude quoted materials from the originality report
    @SerialName("exclude_quoted") val excludeQuoted: Boolean,
    // The type of small matches to exclude ('percent' or 'words')
    @SerialName("exclude_small_matches_type") val excludeSmallMatchesType: String,
    // The value for small matches exclusion
    @SerialName("exclude_small_matches_value") val excludeSmallMatchesValue: Int,
)
