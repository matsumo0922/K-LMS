package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewQuizEntity(
    // The ID of the quiz
    @SerialName("id")
    val id: String,

    // The title of the quiz
    @SerialName("title")
    val title: String,

    // The quiz's instructions
    @SerialName("instructions")
    val instructions: String,

    // The ID of the quiz's assignment group
    @SerialName("assignment_group_id")
    val assignmentGroupId: String,

    // The total point value
    @SerialName("points_possible")
    val pointsPossible: Int,

    // When the quiz is due
    @SerialName("due_at")
    val dueAt: String,

    // When to lock the quiz
    @SerialName("lock_at")
    val lockAt: String? = null,

    // When to unlock the quiz
    @SerialName("unlock_at")
    val unlockAt: String,

    // Whether the quiz is published or unpublished
    @SerialName("published")
    val published: Boolean,

    // The type of grading the assignment receives
    @SerialName("grading_type")
    val gradingType: String,

    // Additional quiz settings
    @SerialName("quiz_settings")
    val quizSettings: me.matsumo.klms.core.model.lms.entity.QuizSettingsEntity? = null
)

//  You likely have a 'QuizSettings' class from a previous example
