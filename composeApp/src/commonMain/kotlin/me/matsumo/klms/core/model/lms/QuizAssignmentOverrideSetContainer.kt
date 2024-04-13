package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideSetContainerEntity

@Serializable
data class QuizAssignmentOverrideSetContainer(
    val quizAssignmentOverrides: QuizAssignmentOverrideSet?,
)

fun QuizAssignmentOverrideSetContainerEntity.translate(): QuizAssignmentOverrideSetContainer {
    return QuizAssignmentOverrideSetContainer(
        quizAssignmentOverrides = quizAssignmentOverrides?.translate(),
    )
}
