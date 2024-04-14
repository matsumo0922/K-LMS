package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ResultEntity

@Serializable
data class LmsResult(
    val id: String,
    val passed: Boolean,
    val assessedAt: Instant,
    val links: ResultLinks,
)

fun ResultEntity.translate(): LmsResult {
    return LmsResult(
        id = id,
        passed = passed,
        assessedAt = Instant.parse(assessedAt),
        links = links.translate(),
    )
}
