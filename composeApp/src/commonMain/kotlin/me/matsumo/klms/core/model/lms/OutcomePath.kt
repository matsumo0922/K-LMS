package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomePath(
        val id: Int,

        val parts: List<OutcomePathPartEntity>? = null
)


fun OutcomePathEntity.translate(): OutcomePath {
    return OutcomePath(
        id = id
    )
}
