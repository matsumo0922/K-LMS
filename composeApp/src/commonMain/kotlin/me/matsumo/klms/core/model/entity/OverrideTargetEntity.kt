package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverrideTargetEntity(
    // the ID of the user or section that the override is targeting
    @SerialName("id")
    val id: Int,

    // the name of the user or section that the override is targeting
    @SerialName("name")
    val name: String
)
