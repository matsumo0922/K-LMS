package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomePathPartEntity

@Serializable
data class OutcomePathPart(
    val name: String,
)

fun OutcomePathPartEntity.translate(): OutcomePathPart {
    return OutcomePathPart(
        name = name,
    )
}
