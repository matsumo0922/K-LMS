package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeRollupScore(
    // The rollup score
    @SerialName("score")
    val score: Double?, // Using Double to accommodate decimal scores

    // The number of alignment scores
    @SerialName("count")
    val count: Int,

    // Links related to the outcome
    @SerialName("links")
    val links: OutcomeLinkEntity
)
