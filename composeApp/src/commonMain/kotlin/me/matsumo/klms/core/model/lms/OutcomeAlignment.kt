package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeAlignmentEntity

@Serializable
data class OutcomeAlignment(
    val id: Int,
    val assignmentId: Int?,
    val assessmentId: Int?,
    val submissionTypes: List<String>?,
    val url: String,
    val title: String,
)

fun OutcomeAlignmentEntity.translate(): OutcomeAlignment {
    return OutcomeAlignment(
        id = id,
        assignmentId = assignmentId,
        assessmentId = assessmentId,
        submissionTypes = submissionTypes,
        url = url,
        title = title,
    )
}
