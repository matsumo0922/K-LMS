package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

        val spamStatus: String? = null
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
        deletedAt = deletedAt
    )
}
