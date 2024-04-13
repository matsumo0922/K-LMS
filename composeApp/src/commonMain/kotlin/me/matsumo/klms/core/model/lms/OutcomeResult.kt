package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeResultEntity

@Serializable
data class OutcomeResult(
    val id: Int,
    val score: Double,
    val submittedOrAssessedAt: String,
    val links: OutcomeResultLinks,
    val percent: Double,
) {

    @Serializable
    data class OutcomeResultLinks(
        val user: String,
        val learningOutcome: String,
        val alignment: String,
    )
}

fun OutcomeResultEntity.translate(): OutcomeResult {
    return OutcomeResult(
        id = id,
        score = score,
        submittedOrAssessedAt = submittedOrAssessedAt,
        links = OutcomeResult.OutcomeResultLinks(
            user = links.user,
            learningOutcome = links.learningOutcome,
            alignment = links.alignment,
        ),
        percent = percent,
    )
}
