package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizQuestionEntity(
    // The ID of the quiz question
    @SerialName("id")
    val id: Int,

    // The ID of the Quiz
    @SerialName("quiz_id")
    val quizId: Int,

    // The order of the question
    @SerialName("position")
    val position: Int,

    // The name of the question
    @SerialName("question_name")
    val questionName: String,

    // The type of the question
    @SerialName("question_type")
    val questionType: String,

    // The text of the question
    @SerialName("question_text")
    val questionText: String,

    // Points for a correct answer
    @SerialName("points_possible")
    val pointsPossible: Int,

    // Comments for a correct answer
    @SerialName("correct_comments")
    val correctComments: String,

    // Comments for an incorrect answer
    @SerialName("incorrect_comments")
    val incorrectComments: String,

    //  Comments regardless of correctness
    @SerialName("neutral_comments")
    val neutralComments: String,

    // Array of available answers
    @SerialName("answers")
    val answers: List<AnswerEntity>?
)
