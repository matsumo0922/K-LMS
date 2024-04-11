package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultLinksEntity(
    // A unique identifier for the user ...
    @SerialName("user")
    val user: String,

    // A unique identifier for the user who created this result
    @SerialName("assessor")
    val assessor: String,

    // A unique identifier for the assessment ...
    @SerialName("assessment")
    val assessment: String
)
