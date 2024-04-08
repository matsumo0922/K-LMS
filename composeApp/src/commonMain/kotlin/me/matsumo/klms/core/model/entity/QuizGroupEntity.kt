package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizGroupEntity(
    // The ID of the question group.
    @SerialName("id")
    val id: Int,

    // The ID of the Quiz
    @SerialName("quiz_id")
    val quizId: Int,

    // The name of the question group.
    @SerialName("name")
    val name: String,

    // The number of questions to choose from
    @SerialName("pick_count")
    val pickCount: Int,

    // The points allotted to each question
    @SerialName("question_points")
    val questionPoints: Int,

    // The ID of the Assessment question bank
    @SerialName("assessment_question_bank_id")
    val assessmentQuestionBankId: Int,

    // The display order of the group
    @SerialName("position")
    val position: Int
)
