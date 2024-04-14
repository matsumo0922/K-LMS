package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseQuizExtensionEntity

@Serializable
data class CourseQuizExtension(
    val userId: Int,
    val extraAttempts: Int,
    val extraTime: Int,
    val manuallyUnlocked: Boolean,
    val endAt: Instant,
)

fun CourseQuizExtensionEntity.translate(): CourseQuizExtension {
    return CourseQuizExtension(
        userId = userId,
        extraAttempts = extraAttempts,
        extraTime = extraTime,
        manuallyUnlocked = manuallyUnlocked,
        endAt = Instant.parse(endAt),
    )
}
