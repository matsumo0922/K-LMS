package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ResultEntity

@Serializable
data class Result(
    val id: String,
    val passed: Boolean,
    val assessedAt: String,
    val links: ResultLinks,
)

fun ResultEntity.translate(): Result {
    return Result(
        id = id,
        passed = passed,
        assessedAt = assessedAt,
        links = links.translate(),
    )
}
