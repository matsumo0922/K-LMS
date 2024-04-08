package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ColumnDatumEntity(
    @SerialName("content")
    val content: String,

    @SerialName("user_id")
    val userId: Int
)
