package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnswerEntity(
    // The unique identifier for the answer.
    @SerialName("id")
    val id: Int?,  // Optional for new questions

    // The text of the answer.
    @SerialName("answer_text")
    val answerText: String,

    // Correctness of the answer (0 to 100)
    @SerialName("answer_weight")
    val answerWeight: Int,

    // Contextual comments
    @SerialName("answer_comments")
    val answerComments: String?,

    // Text to follow the missing word
    @SerialName("text_after_answers")
    val textAfterAnswers: String?,

    // For matching questions - left side
    @SerialName("answer_match_left")
    val answerMatchLeft: String?,

    // For matching questions - right side
    @SerialName("answer_match_right")
    val answerMatchRight: String?,

    // Incorrect matches for matching questions
    @SerialName("matching_answer_incorrect_matches")
    val matchingAnswerIncorrectMatches: List<String>?,

    // Numerical question answer type
    @SerialName("numerical_answer_type")
    val numericalAnswerType: String?,

    // For 'exact_answer'
    @SerialName("exact")
    val exact: Double?,

    // Margin of error for 'exact_answer'
    @SerialName("margin")
    val margin: Double?,

    // Approx value for 'precision_answer'
    @SerialName("approximate")
    val approximate: Double?,

    //  Numerical precision for 'precision_answer'
    @SerialName("precision")
    val precision: Int?,

    // Range start for 'range_answer'
    @SerialName("start")
    val start: Int?,

    // Range end for 'range_answer'
    @SerialName("end")
    val end: Int?,

    // For fill-in blanks, multiple dropdown
    @SerialName("blank_id")
    val blankId: Int?
)
