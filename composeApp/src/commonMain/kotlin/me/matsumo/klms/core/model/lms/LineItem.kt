package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LineItemEntity

@Serializable
data class LineItem(
    val id: String,
    val scoreMaximum: Double,
    val label: String,
    val tag: String,
    val resourceId: String,
    val resourceLinkId: String,
    val submissionType: SubmissionType? = null,
    val launchUrl: String? = null,
) {
    @Serializable
    data class SubmissionType(
        val type: String,
        val externalToolUrl: String,
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
        submissionType = submissionType?.let {
            LineItem.SubmissionType(
                type = it.type,
                externalToolUrl = it.externalToolUrl,
            )
        },
        launchUrl = launchUrl,
    )
}
