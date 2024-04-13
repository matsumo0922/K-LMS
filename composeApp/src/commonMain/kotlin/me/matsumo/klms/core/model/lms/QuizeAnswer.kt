package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AnswerEntity

@Serializable
data class QuizeAnswer(
    val id: Int?,
    val answerText: String,
    val answerWeight: Int,
    val answerComments: String?,
    val textAfterAnswers: String?,
    val answerMatchLeft: String?,
    val answerMatchRight: String?,
    val matchingAnswerIncorrectMatches: List<String>?,
    val numericalAnswerType: String?,
    val exact: Double?,
    val margin: Double?,
    val approximate: Double?,
    val precision: Int?,
    val start: Int?,
    val end: Int?,
    val blankId: Int?,
)

fun AnswerEntity.translate(): QuizeAnswer {
    return QuizeAnswer(
        id = id,
        answerText = answerText,
        answerWeight = answerWeight,
        answerComments = answerComments,
        textAfterAnswers = textAfterAnswers,
        answerMatchLeft = answerMatchLeft,
        answerMatchRight = answerMatchRight,
        matchingAnswerIncorrectMatches = matchingAnswerIncorrectMatches,
        numericalAnswerType = numericalAnswerType,
        exact = exact,
        margin = margin,
        approximate = approximate,
        precision = precision,
        start = start,
        end = end,
        blankId = blankId,
    )
}
