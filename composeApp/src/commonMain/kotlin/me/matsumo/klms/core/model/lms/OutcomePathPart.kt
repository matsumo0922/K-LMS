package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomePathPart(
    val name: String
)

fun OutcomePathPartEntity.translate(): OutcomePathPart {
    return OutcomePathPart(
        
    )
}
