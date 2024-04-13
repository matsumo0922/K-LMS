package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizExtensionEntity

@Serializable
data class QuizExtension(
    val quizId: Int,
    val userId: Int,
    val extraAttempts: Int,
    val extraTime: Int,
    val manuallyUnlocked: Boolean,
    val endAt: String,
)

fun QuizExtensionEntity.translate(): QuizExtension {
    return QuizExtension(
        quizId = quizId,
        userId = userId,
        extraAttempts = extraAttempts,
        extraTime = extraTime,
        manuallyUnlocked = manuallyUnlocked,
        endAt = endAt,
    )
}
