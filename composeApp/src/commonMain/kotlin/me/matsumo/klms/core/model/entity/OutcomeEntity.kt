package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class OutcomeEntity(
    // The ID of the outcome
    @SerialName("id")
    val id: Int,

    // The URL for fetching/updating the outcome
    @SerialName("url")
    val url: String,

    // The context owning the outcome
    @SerialName("context_id")
    val contextId: Int?,

    @SerialName("context_type")
    val contextType: String,

    // Title of the outcome
    @SerialName("title")
    val title: String,

    // Optional friendly name for reporting
    @SerialName("display_name")
    val displayName: String?,

    // Description
    @SerialName("description")
    val description: String?,

    // Custom GUID
    @SerialName("vendor_guid")
    val vendorGuid: String?,

    // Maximum points possible
    @SerialName("points_possible")
    val pointsPossible: Double?, // Using Double for potential decimals

    // Points for mastery
    @SerialName("mastery_points")
    val masteryPoints: Double?,

    // Method used to calculate scores
    @SerialName("calculation_method")
    val calculationMethod: String,

    // Variable value used by 'calculation_method'
    @SerialName("calculation_int")
    val calculationInt: Int?,

    // Possible ratings
    @SerialName("ratings")
    val ratings: List<Rating>?,

    // Whether the current user can update the outcome
    @SerialName("can_edit")
    val canEdit: Boolean,

    // Whether the outcome can be unlinked
    @SerialName("can_unlink")
    val canUnlink: Boolean,

    // Whether this outcome has been used to assess a student
    @SerialName("assessed")
    val assessed: Boolean,

    // Whether updates to this outcome will propagate to unassessed rubrics
    @SerialName("has_updateable_rubrics")
    val hasUpdateableRubrics: Boolean
)
