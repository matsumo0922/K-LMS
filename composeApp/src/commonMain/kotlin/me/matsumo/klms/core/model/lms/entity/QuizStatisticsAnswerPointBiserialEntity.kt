package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizStatisticsAnswerPointBiserialEntity(
    // ID of the answer
    @SerialName("answer_id")
    val answerId: Int,
    // The point-biserial value
    @SerialName("point_biserial")
    val pointBiserial: Double,
    // Whether this is the correct answer (optional)
    @SerialName("correct")
    val correct: Boolean?,
    // Whether this is a distractor answer (optional)
    @SerialName("distractor")
    val distractor: Boolean?,
)
