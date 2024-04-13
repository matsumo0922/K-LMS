package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizAssignmentOverrideSetContainerEntity(
    // The QuizAssignmentOverrideSet
    @SerialName("quiz_assignment_overrides")
    val quizAssignmentOverrides: me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideSetEntity?, // You have this defined previously
)
