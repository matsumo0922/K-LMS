package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPortfolioEntity(
    // The database ID of the ePortfolio
    @SerialName("id")
    val id: Int,
    // The user ID to which the ePortfolio belongs
    @SerialName("user_id")
    val userId: Int,
    // The name of the ePortfolio
    @SerialName("name")
    val name: String,
    // Whether or not the ePortfolio is visible without authentication
    @SerialName("public")
    val public: Boolean,
    // The creation timestamp for the ePortfolio
    @SerialName("created_at")
    val createdAt: String,
    // The timestamp of the last time any of the ePortfolio attributes changed
    @SerialName("updated_at")
    val updatedAt: String,
    // The state of the ePortfolio. Either 'active' or 'deleted'
    @SerialName("workflow_state")
    val workflowState: String,
    // The timestamp when the ePortfolio was deleted, or else null
    @SerialName("deleted_at")
    val deletedAt: String? = null,
    // A flag indicating whether the ePortfolio has been ...
    @SerialName("spam_status")
    val spamStatus: String? = null,
)
