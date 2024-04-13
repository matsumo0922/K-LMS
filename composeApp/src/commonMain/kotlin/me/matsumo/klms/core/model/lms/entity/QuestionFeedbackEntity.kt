package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionFeedbackEntity(
    @SerialName("neutral")
    val neutral: String,
    @SerialName("correct")
    val correct: String,
    @SerialName("incorrect")
    val incorrect: String,
)
