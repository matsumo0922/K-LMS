package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeRollup(
        val scores: List<OutcomeRollupScore>? = null,

    val name: String,

    val links: Links
) {
    @Serializable
    data class Links(
        val course: Int,

        val user: Int,

        val section: Int
    )
}

fun OutcomeRollupEntity.translate(): OutcomeRollup {
    return OutcomeRollup(
        scores = scores,
        name = name,
        course = course,
        user = user
    )
}
