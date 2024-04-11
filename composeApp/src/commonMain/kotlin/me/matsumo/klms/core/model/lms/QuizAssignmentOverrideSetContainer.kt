package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizAssignmentOverrideSetContainer(
        val quizAssignmentOverrides: QuizAssignmentOverrideSetEntity? )

fun QuizAssignmentOverrideSetContainerEntity.translate(): QuizAssignmentOverrideSetContainer {
    return QuizAssignmentOverrideSetContainer(
        
    )
}
