package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseQuizExtensionEntity

@Serializable
data class CourseQuizExtension(
    val userId: Int,
    val extraAttempts: Int,
    val extraTime: Int,
    val manuallyUnlocked: Boolean,
    val endAt: String,
)

fun CourseQuizExtensionEntity.translate(): CourseQuizExtension {
    return CourseQuizExtension(
        userId = userId,
        extraAttempts = extraAttempts,
        extraTime = extraTime,
        manuallyUnlocked = manuallyUnlocked,
        endAt = endAt,
    )
}
