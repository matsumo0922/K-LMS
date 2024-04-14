package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EPortfolioEntity

@Serializable
data class EPortfolio(
    val id: Int,
    val userId: Int,
    val name: String,
    val public: Boolean,
    val createdAt: Instant,
    val updatedAt: Instant,
    val workflowState: String,
    val deletedAt: Instant? = null,
    val spamStatus: String? = null,
)

fun EPortfolioEntity.translate(): EPortfolio {
    return EPortfolio(
        id = id,
        userId = userId,
        name = name,
        public = public,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        workflowState = workflowState,
        deletedAt = deletedAt?.let { Instant.parse(it) },
        spamStatus = spamStatus,
    )
}
