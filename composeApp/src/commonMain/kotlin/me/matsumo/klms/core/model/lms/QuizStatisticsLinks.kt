package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsLinks(
        val quiz: String
)

fun QuizStatisticsLinksEntity.translate(): QuizStatisticsLinks {
    return QuizStatisticsLinks(
        
    )
}
