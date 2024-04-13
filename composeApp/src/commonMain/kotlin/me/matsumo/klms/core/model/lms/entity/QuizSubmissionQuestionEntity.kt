package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizSubmissionQuestionEntity(
    // The ID of the QuizQuestion
    @SerialName("id")
    val id: Int,
    // Whether the question is flagged
    @SerialName("flagged")
    val flagged: Boolean,
    // The provided answer (format depends on question type)
    @SerialName("answer")
    val answer: me.matsumo.klms.core.model.lms.entity.AnswerEntity?, // Placeholder - Type depends on question type

    // Possible answers (if permissions allow)
    @SerialName("answers")
    val answers: List<me.matsumo.klms.core.model.lms.entity.AnswerEntity>?, // Placeholder - Type depends on answer structure
)
