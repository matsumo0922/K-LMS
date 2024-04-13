package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CompletionRequirementEntity

@Serializable
data class CompletionRequirement(
    val type: String,
    val minScore: Int? = null,
    val completed: Boolean? = null,
)

fun CompletionRequirementEntity.translate(): CompletionRequirement {
    return CompletionRequirement(
        type = type,
        minScore = minScore,
        completed = completed,
    )
}
