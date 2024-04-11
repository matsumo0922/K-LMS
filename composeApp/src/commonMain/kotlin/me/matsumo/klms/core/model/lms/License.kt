package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
        val id: String,

        val name: String,

        val url: String
)

fun LicenseEntity.translate(): License {
    return License(
        id = id,
        name = name
    )
}
