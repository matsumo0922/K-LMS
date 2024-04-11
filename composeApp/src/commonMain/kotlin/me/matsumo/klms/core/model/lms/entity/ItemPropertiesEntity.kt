package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemPropertiesEntity(
    @SerialName("sample_num")
    val sampleNum: Int? = null
)
