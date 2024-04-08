package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssessmentEntity(
    //  A unique identifier for this live assessment
    @SerialName("id")
    val id: String,

    // A client specified unique identifier for the assessment
    @SerialName("key")
    val key: String,

    // A human readable title for the assessment
    @SerialName("title")
    val title: String
)
