package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineItem(
        val id: String,

        val scoreMaximum: Double,

        val label: String,

        val tag: String,

        val resourceId: String,

        val resourceLinkId: String,

        @SerialName("https:    val submissionType: SubmissionType? = null ,

        @SerialName("https:    val launchUrl: String? = null
) {
    @Serializable
    data class SubmissionType(
        val type: String,

        val externalToolUrl: String
    )
}

fun LineItemEntity.translate(): LineItem {
    return LineItem(
        id = id,
        scoreMaximum = scoreMaximum,
        label = label,
        tag = tag,
        resourceId = resourceId,
        resourceLinkId = resourceLinkId,
        submissionType = submissionType,
        type = type
    )
}
