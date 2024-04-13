package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeRollupEntity
import me.matsumo.klms.core.model.lms.entity.OutcomeRollupScoreEntity

@Serializable
data class OutcomeRollup(
    val scores: List<OutcomeRollupScoreEntity>? = null,
    val name: String,
    val links: Links,
) {
    @Serializable
    data class Links(
        val course: Int,
        val user: Int,
        val section: Int,
    )
}

fun OutcomeRollupEntity.translate(): OutcomeRollup {
    return OutcomeRollup(
        scores = scores,
        name = name,
        links = OutcomeRollup.Links(
            course = links.course,
            user = links.user,
            section = links.section,
        ),
    )
}
