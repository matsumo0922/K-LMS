package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideSetEntity

@Serializable
data class QuizAssignmentOverrideSet(
    val quizId: String,
    val dueDates: List<QuizAssignmentOverride>,
    val allDates: List<QuizAssignmentOverride>,
)

fun QuizAssignmentOverrideSetEntity.translate(): QuizAssignmentOverrideSet {
    return QuizAssignmentOverrideSet(
        quizId = quizId,
        dueDates = dueDates?.map { it.translate() } ?: emptyList(),
        allDates = allDates?.map { it.translate() } ?: emptyList(),
    )
}
