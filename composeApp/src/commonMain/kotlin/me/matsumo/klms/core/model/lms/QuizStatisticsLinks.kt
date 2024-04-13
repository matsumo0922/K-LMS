package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizStatisticsLinksEntity

@Serializable
data class QuizStatisticsLinks(
    val quiz: String,
)

fun QuizStatisticsLinksEntity.translate(): QuizStatisticsLinks {
    return QuizStatisticsLinks(
        quiz = quiz,
    )
}
