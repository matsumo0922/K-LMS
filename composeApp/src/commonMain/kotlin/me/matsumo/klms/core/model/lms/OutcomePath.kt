package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomePathEntity

@Serializable
data class OutcomePath(
    val id: Int,
    val parts: List<OutcomePathPart>? = null,
)

fun OutcomePathEntity.translate(): OutcomePath {
    return OutcomePath(
        id = id,
        parts = parts?.map { it.translate() },
    )
}
