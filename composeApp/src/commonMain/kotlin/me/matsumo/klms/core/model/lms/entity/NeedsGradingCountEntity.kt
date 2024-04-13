package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Used by Assignment model
@Serializable
data class NeedsGradingCountEntity(
    // The section ID
    @SerialName("section_id") val sectionId: String,
    // Number of submissions that need grading
    @SerialName("needs_grading_count") val needsGradingCount: Int,
)
