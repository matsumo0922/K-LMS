package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EPortfolioPageEntity

@Serializable
data class EPortfolioPage(
    val id: Int,
    val eportfolioId: Int,
    val position: Int,
    val name: String,
    val content: String,
    val createdAt: Instant,
    val updatedAt: Instant,
)

fun EPortfolioPageEntity.translate(): EPortfolioPage {
    return EPortfolioPage(
        id = id,
        eportfolioId = eportfolioId,
        position = position,
        name = name,
        content = content,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
    )
}
