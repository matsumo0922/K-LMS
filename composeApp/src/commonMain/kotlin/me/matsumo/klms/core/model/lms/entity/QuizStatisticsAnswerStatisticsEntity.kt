package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsAnswerStatisticsEntity(
    // ID of the answer
    @SerialName("id")
    val id: Int,
    // The text associated with the answer
    @SerialName("text")
    val text: String,
    // The correctness of the answer (0 to 100)
    @SerialName("weight")
    val weight: Int,
    // The number  of students who chose this answer
    @SerialName("responses")
    val responses: Int,
)
