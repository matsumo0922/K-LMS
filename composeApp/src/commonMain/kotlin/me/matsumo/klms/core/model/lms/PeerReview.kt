package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PeerReviewEntity

@Serializable
data class PeerReview(
    val assessorId: Int,
    val assetId: Int,
    val assetType: String,
    val id: Int,
    val userId: Int,
    val workflowState: String,
    val user: LmsUser?,
    val assessor: LmsUser?,
    val submissionComments: List<SubmissionComment>?,
)

fun PeerReviewEntity.translate(): PeerReview {
    return PeerReview(
        assessorId = assessorId,
        assetId = assetId,
        assetType = assetType,
        id = id,
        userId = userId,
        workflowState = workflowState,
        user = user?.translate(),
        assessor = assessor?.translate(),
        submissionComments = submissionComments?.map { it.translate() },
    )
}
