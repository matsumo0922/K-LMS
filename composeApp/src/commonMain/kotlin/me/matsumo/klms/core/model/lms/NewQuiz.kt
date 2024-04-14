package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.NewQuizEntity

@Serializable
data class NewQuiz(
    val id: String,
    val title: String,
    val instructions: String,
    val assignmentGroupId: String,
    val pointsPossible: Int,
    val dueAt: Instant,
    val lockAt: Instant? = null,
    val unlockAt: Instant,
    val published: Boolean,
    val gradingType: String,
    val quizSettings: QuizSettings? = null,
)

fun NewQuizEntity.translate(): NewQuiz {
    return NewQuiz(
        id = id,
        title = title,
        instructions = instructions,
        assignmentGroupId = assignmentGroupId,
        pointsPossible = pointsPossible,
        dueAt = Instant.parse(dueAt),
        lockAt = lockAt?.let { Instant.parse(it) },
        unlockAt = Instant.parse(unlockAt),
        published = published,
        gradingType = gradingType,
        quizSettings = quizSettings?.translate(),
    )
}
