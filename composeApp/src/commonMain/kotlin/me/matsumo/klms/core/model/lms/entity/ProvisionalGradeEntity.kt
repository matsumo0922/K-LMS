package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProvisionalGradeEntity(
    // The identifier for the provisional grade
    @SerialName("provisional_grade_id")
    val provisionalGradeId: Int,
    // The numeric score
    @SerialName("score")
    val score: Double, // Using 'Double' for decimal accuracy

    // The grade
    @SerialName("grade")
    val grade: String,
    // Whether the grade was applied to the most current submission ...
    @SerialName("grade_matches_current_submission")
    val gradeMatchesCurrentSubmission: Boolean,
    // When the grade was given
    @SerialName("graded_at")
    val gradedAt: String,
    // Whether this is the 'final' ...
    @SerialName("final")
    val final: Boolean,
    // A link to view this provisional grade ...
    @SerialName("speedgrader_url")
    val speedgraderUrl: String,
)
