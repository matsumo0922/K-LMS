package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EPortfolioEntity

@Serializable
data class EPortfolio(
    val id: Int,
    val userId: Int,
    val name: String,
    val public: Boolean,
    val createdAt: String,
    val updatedAt: String,
    val workflowState: String,
    val deletedAt: String? = null,
    val spamStatus: String? = null,
)

fun EPortfolioEntity.translate(): EPortfolio {
    return EPortfolio(
        id = id,
        userId = userId,
        name = name,
        public = public,
        createdAt = createdAt,
        updatedAt = updatedAt,
        workflowState = workflowState,
        deletedAt = deletedAt,
        spamStatus = spamStatus,
    )
}
