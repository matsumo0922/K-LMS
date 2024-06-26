package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingStandardEntity(
    // the title of the grading standard
    @SerialName("title")
    val title: String,
    // the id of the grading standard
    @SerialName("id")
    val id: Int,
    // the context this standard is associated with ...
    @SerialName("context_type")
    val contextType: String,
    // the id for the context either the Account or Course id
    @SerialName("context_id")
    val contextId: Int,
    // A list of GradingSchemeEntry that make up the Grading Standard ...
    @SerialName("grading_scheme")
    val gradingScheme: List<GradingScheme>,
) {
    @Serializable
    data class GradingScheme(
        // the name of the grading scheme entry
        @SerialName("name")
        val name: String,
        // the value of the grading scheme entry
        @SerialName("value")
        val value: Double,
    )
}

// You'll need the GradingSchemeEntry data class from our previous example
