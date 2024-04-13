package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsLinksEntity(
    // API URL to the quiz
    @SerialName("quiz")
    val quiz: String,
)
