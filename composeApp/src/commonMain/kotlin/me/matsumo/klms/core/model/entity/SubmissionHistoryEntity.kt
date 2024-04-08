package me.matsumo.klms.core.model.entity

import io.ktor.http.content.Version
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class SubmissionHistoryEntity(
    @SerialName("submission_id")
    val submissionId: Int,

    @SerialName("versions")
    val versions: List<SubmissionVersionEntity>?
)
