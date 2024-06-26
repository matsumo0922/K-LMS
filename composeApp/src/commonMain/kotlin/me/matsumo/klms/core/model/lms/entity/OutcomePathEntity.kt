package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomePathEntity(
    // A unique identifier for this outcome
    @SerialName("id")
    val id: Int,
    // an array of OutcomePathPart objects
    @SerialName("parts")
    val parts: List<me.matsumo.klms.core.model.lms.entity.OutcomePathPartEntity>? = null,
)

// You'll have the 'OutcomePathPart' class defined from a previous example
