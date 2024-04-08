package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPortfolioPageEntity(
    // The database ID of the ePortfolio
    @SerialName("id")
    val id: Int,

    // The ePortfolio ID to which the entry belongs
    @SerialName("eportfolio_id")
    val eportfolioId: Int,

    // The positional order of the entry in the list
    @SerialName("position")
    val position: Int,

    // The name of the ePortfolio
    @SerialName("name")
    val name: String,

    // The user entered content of the entry
    @SerialName("content")
    val content: String,

    // The creation timestamp for the ePortfolio
    @SerialName("created_at")
    val createdAt: String,

    // The timestamp of the last time any of the ePortfolio attributes changed
    @SerialName("updated_at")
    val updatedAt: String
)
