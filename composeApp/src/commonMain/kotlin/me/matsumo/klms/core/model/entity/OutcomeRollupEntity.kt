package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class OutcomeRollupEntity(
    // An array of OutcomeRollupScore
    @SerialName("scores")
    val scores: List<OutcomeRollupScoreE>? = null,

    @SerialName("name")
    val name: String,

    @SerialName("links")
    val links: Links
)

@kotlinx.serialization.Serializable
data class Links(
    @SerialName("course")
    val course: Int,

    @SerialName("user")
    val user: Int,

    @SerialName("section")
    val section: Int
)
