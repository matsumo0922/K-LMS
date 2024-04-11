package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeRollupEntity(
    // An array of OutcomeRollupScore
    @SerialName("scores")
    val scores: List<me.matsumo.klms.core.model.lms.entity.OutcomeRollupScore>? = null,

    @SerialName("name")
    val name: String,

    @SerialName("links")
    val links: me.matsumo.klms.core.model.lms.entity.OutcomeRollupEntity.Links
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
