package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseQuizExtension(
        val userId: Int,

        val extraAttempts: Int,

        val extraTime: Int,

        val manuallyUnlocked: Boolean,

        val endAt: String
)

fun CourseQuizExtensionEntity.translate(): CourseQuizExtension {
    return CourseQuizExtension(
        userId = userId,
        extraAttempts = extraAttempts,
        extraTime = extraTime,
        manuallyUnlocked = manuallyUnlocked
    )
}
