package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PeerReviewEntity(
    // The assessor's user id
    @SerialName("assessor_id")
    val assessorId: Int,

    // The ID of the asset
    @SerialName("asset_id")
    val assetId: Int,

    // The type of the asset
    @SerialName("asset_type")
    val assetType: String,

    // The ID of the Peer Review
    @SerialName("id")
    val id: Int,

    // The user ID for the owner of the asset
    @SerialName("user_id")
    val userId: Int,

    // The state of the Peer Review
    @SerialName("workflow_state")
    val workflowState: String,

    // The 'User' object for the asset owner (optional)
    @SerialName("user")
    val user: UserEntity?,

    //  The 'User' object for the assessor (optional)
    @SerialName("assessor")
    val assessor: UserEntity?,

    // (Optional) Submission comments
    @SerialName("submission_comments")
    val submissionComments: List<SubmissionCommentEntity>?
)
