package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizAssignmentOverrideSetEntity(
    // ID of the quiz
    @SerialName("quiz_id")
    val quizId: String,

    // Array of assignment overrides for a particular student
    @SerialName("due_dates")
    val dueDates: List<me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideEntity>?,

    // Array of all assignment overrides for a quiz (for teachers/staff)
    @SerialName("all_dates")
    val allDates: List<me.matsumo.klms.core.model.lms.entity.QuizAssignmentOverrideEntity>?
)
