package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeLinkEntity(
    // The URL for fetching/updating the outcome link
    @SerialName("url")
    val url: String,

    // The context owning the outcome link
    @SerialName("context_id")
    val contextId: Int,

    @SerialName("context_type")
    val contextType: String,

    // An abbreviated OutcomeGroup
    @SerialName("outcome_group")
    val outcomeGroup: OutcomeGroupEntity?,

    // An abbreviated Outcome object
    @SerialName("outcome")
    val outcome: OutcomeEntity?,

    // Whether this outcome has been used to assess a student
    @SerialName("assessed")
    val assessed: Boolean,

    // Whether this outcome link is manageable
    @SerialName("can_unlink")
    val canUnlink: Boolean? = null
)
