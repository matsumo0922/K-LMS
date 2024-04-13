package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmissionHistoryEntity(
    @SerialName("submission_id")
    val submissionId: Int,
    @SerialName("versions")
    val versions: List<me.matsumo.klms.core.model.lms.entity.SubmissionVersionEntity>?,
)
