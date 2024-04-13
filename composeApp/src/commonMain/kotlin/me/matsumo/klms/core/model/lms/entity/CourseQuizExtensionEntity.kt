package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseQuizExtensionEntity(
    // The ID of the Student that needs the quiz extension.
    @SerialName("user_id")
    val userId: Int,
    // Number of times the student is allowed to re-take the quiz ...
    @SerialName("extra_attempts")
    val extraAttempts: Int,
    // Amount of extra time allowed for the quiz submission, in minutes.
    @SerialName("extra_time")
    val extraTime: Int,
    // The student can take the quiz even if it's locked ..
    @SerialName("manually_unlocked")
    val manuallyUnlocked: Boolean,
    // The time at which the quiz submission will be overdue ...
    @SerialName("end_at")
    val endAt: String,
)
