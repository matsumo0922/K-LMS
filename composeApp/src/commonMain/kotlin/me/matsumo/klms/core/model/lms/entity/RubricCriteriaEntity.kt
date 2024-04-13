package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RubricCriteriaEntity(
    // Points associated with the rubric criteria
    @SerialName("points") val points: Int,
    // The id of rubric criteria.
    @SerialName("id") val id: String,
    // (Optional) The id of the learning outcome this criteria uses, if any.
    @SerialName("learning_outcome_id") val learningOutcomeId: String?,
    // (Optional) The 3rd party vendor's GUID for the outcome this criteria references, if any.
    @SerialName("vendor_guid") val vendorGuid: String?,
    // Brief description of the rubric criteria
    @SerialName("description") val description: String,
    // Detailed description of the rubric criteria
    @SerialName("long_description") val longDescription: String,
    // Whether the criterion uses range
    @SerialName("criterion_use_range") val criterionUseRange: Boolean,
    // The ratings associated with this criterion
    @SerialName("ratings") val ratings: List<me.matsumo.klms.core.model.lms.entity.RubricRatingEntity>?,
    // Whether this criterion should be ignored for scoring
    @SerialName("ignore_for_scoring") val ignoreForScoring: Boolean,
)
