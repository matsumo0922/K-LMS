package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizPermissionsEntity(
    // Whether the user can view the quiz
    @SerialName("read")
    val read: Boolean,

    // Whether the user can submit a submission
    @SerialName("submit")
    val submit: Boolean,

    // Whether the user can create a new quiz
    @SerialName("create")
    val create: Boolean,

    // Whether the user can manage the quiz (edit, update, delete)
    @SerialName("manage")
    val manage: Boolean,

    // Whether the user can view quiz statistics
    @SerialName("read_statistics")
    val readStatistics: Boolean,

    // Whether the user can review grades
    @SerialName("review_grades")
    val reviewGrades: Boolean,

    // Whether the user can update the quiz
    @SerialName("update")
    val update: Boolean
)
