package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.SubmissionHistoryEntity

@Serializable
data class SubmissionHistory(
    val submissionId: Int,
    val versions: List<SubmissionVersion>,
)

fun SubmissionHistoryEntity.translate(): SubmissionHistory {
    return SubmissionHistory(
        submissionId = submissionId,
        versions = versions?.map { it.translate() } ?: emptyList(),
    )
}
