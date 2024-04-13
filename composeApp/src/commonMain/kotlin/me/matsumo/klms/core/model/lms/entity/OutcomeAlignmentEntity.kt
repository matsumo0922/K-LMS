package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable@Serializable
data class OutcomeAlignmentEntity(
    @SerialName("id")
    val id: Int,
    @SerialName("assignment_id")
    val assignmentId: Int?,
    @SerialName("assessment_id")
    val assessmentId: Int?,
    @SerialName("submission_types")
    val submissionTypes: List<String>?, // Assuming a list of submission types

    @SerialName("url")
    val url: String,
    @SerialName("title")
    val title: String,
)
