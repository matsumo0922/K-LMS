package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeRollupEntity(
    // An array of OutcomeRollupScore
    @SerialName("scores")
    val scores: List<OutcomeRollupScore>? = null,

    @SerialName("name")
    val name: String,

    @SerialName("links")
    val links: Links
) {
    @Serializable
    data class Links(
        @SerialName("course")
        val course: Int,

        @SerialName("user")
        val user: Int,

        @SerialName("section")
        val section: Int
    )
}
