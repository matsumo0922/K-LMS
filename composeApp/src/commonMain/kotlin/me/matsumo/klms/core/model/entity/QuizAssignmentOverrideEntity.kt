package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizAssignmentOverrideEntity(
    // ID of the assignment override (omitted if 'base' is true)
    @SerialName("id")
    val id: Int?,

    // Submission due date
    @SerialName("due_at")
    val dueAt: String,

    // Quiz availability start date
    @SerialName("unlock_at")
    val unlockAt: String?,

    // Quiz availability end date
    @SerialName("lock_at")
    val lockAt: String?,

    // Title of the section this override is for
    @SerialName("title")
    val title: String?,

    // Indicates if this override is for all students
    @SerialName("base")
    val base: Boolean?
)
