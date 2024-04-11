package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPortfolioPage(
        val id: Int,

        val eportfolioId: Int,

        val position: Int,

        val name: String,

        val content: String,

        val createdAt: String,

        val updatedAt: String
)

fun EPortfolioPageEntity.translate(): EPortfolioPage {
    return EPortfolioPage(
        id = id,
        eportfolioId = eportfolioId,
        position = position,
        name = name,
        content = content,
        createdAt = createdAt
    )
}
