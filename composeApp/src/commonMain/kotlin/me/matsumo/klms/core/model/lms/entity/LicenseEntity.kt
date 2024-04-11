package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseEntity(
    // a short string identifying the license
    @SerialName("id")
    val id: String,

    // the name of the license
    @SerialName("name")
    val name: String,

    // a link to the license text
    @SerialName("url")
    val url: String
)
