package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizAssignmentOverrideSet(
        val quizId: String,

        val dueDates: List<QuizAssignmentOverrideEntity>?,

        val allDates: List<QuizAssignmentOverrideEntity>?
)

fun QuizAssignmentOverrideSetEntity.translate(): QuizAssignmentOverrideSet {
    return QuizAssignmentOverrideSet(
        quizId = quizId,
        dueDates = dueDates
    )
}
