package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleContextEntity(
    @SerialName("id")
    val id: String,

    @SerialName("label")
    val label: String,

    @SerialName("title")
    val title: String
)
