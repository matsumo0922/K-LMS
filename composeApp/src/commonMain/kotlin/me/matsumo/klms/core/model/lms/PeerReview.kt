package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PeerReview(
        val assessorId: Int,

        val assetId: Int,

        val assetType: String,

        val id: Int,

        val userId: Int,

        val workflowState: String,

        val user: UserEntity?,

        val assessor: UserEntity?,

        val submissionComments: List<SubmissionCommentEntity>?
)

fun PeerReviewEntity.translate(): PeerReview {
    return PeerReview(
        assessorId = assessorId,
        assetId = assetId,
        assetType = assetType,
        id = id,
        userId = userId,
        workflowState = workflowState,
        user = user,
        assessor = assessor
    )
}
