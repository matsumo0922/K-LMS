package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizExtensionEntity(
    // The ID of the Quiz
    @SerialName("quiz_id")
    val quizId: Int,

    // The ID of the Student
    @SerialName("user_id")
    val userId: Int,

    // Additional retake attempts allowed
    @SerialName("extra_attempts")
    val extraAttempts: Int,

    // Additional time allowed (in minutes)
    @SerialName("extra_time")
    val extraTime: Int,

    // Whether the student can take the quiz even when locked
    @SerialName("manually_unlocked")
    val manuallyUnlocked: Boolean,

    //  Submission deadline
    @SerialName("end_at")
    val endAt: String
)
