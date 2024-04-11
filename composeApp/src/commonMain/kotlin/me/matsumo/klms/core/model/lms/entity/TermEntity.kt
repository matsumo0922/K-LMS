package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TermEntity(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("start_at")
    val startAt: String,

    @SerialName("end_at")
    val endAt: String? = null
)
