package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultEntity(
    // A unique identifier for this result
    @SerialName("id")
    val id: String,

    // Whether the user passed or not
    @SerialName("passed")
    val passed: Boolean,

    // When this result was recorded
    @SerialName("assessed_at")
    val assessedAt: String,

    // Unique identifiers of objects associated with this result
    @SerialName("links")
    val links: me.matsumo.klms.core.model.lms.entity.ResultLinksEntity
)

// You'll need the ResultLinksEntity data class from the previous example.
