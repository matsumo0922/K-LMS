package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsQuestionStatisticsEntity(
    // Number of students with non-blank answers
    @SerialName("responses")
    val responses: Int,
    // Statistics for each pre-defined answer
    @SerialName("answers")
    val answers: List<me.matsumo.klms.core.model.lms.entity.QuizStatisticsAnswerStatisticsEntity>?,
)
