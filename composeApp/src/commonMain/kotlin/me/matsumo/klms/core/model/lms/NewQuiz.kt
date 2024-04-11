package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewQuiz(
        val id: String,

        val title: String,

        val instructions: String,

        val assignmentGroupId: String,

        val pointsPossible: Int,

        val dueAt: String,

        val lockAt: String? = null,

        val unlockAt: String,

        val published: Boolean,

        val gradingType: String,

        val quizSettings: QuizSettingsEntity? = null
)


fun NewQuizEntity.translate(): NewQuiz {
    return NewQuiz(
        id = id,
        title = title,
        instructions = instructions,
        assignmentGroupId = assignmentGroupId,
        pointsPossible = pointsPossible,
        dueAt = dueAt,
        lockAt = lockAt,
        unlockAt = unlockAt,
        published = published,
        gradingType = gradingType
    )
}
