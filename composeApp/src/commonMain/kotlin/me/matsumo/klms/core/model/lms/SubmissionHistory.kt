package me.matsumo.klms.core.model.entity

import io.ktor.http.content.Version
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionHistory(
    val submissionId: Int,

    val versions: List<SubmissionVersionEntity>?
)

fun SubmissionHistoryEntity.translate(): SubmissionHistory {
    return SubmissionHistory(
        submissionId = submissionId
    )
}
