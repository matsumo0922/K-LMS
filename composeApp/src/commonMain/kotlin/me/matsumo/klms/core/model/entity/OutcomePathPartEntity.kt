package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomePathPartEntity(
    @SerialName("name")
    val name: String
)
