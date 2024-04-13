package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradeEntity

@Serializable
data class Grade(
    val htmlUrl: String,
    val currentGrade: String? = null,
    val finalGrade: String? = null,
    val currentScore: Double? = null,
    val finalScore: Double? = null,
    val currentPoints: Double? = null,
    val unpostedCurrentGrade: String? = null,
    val unpostedFinalGrade: String? = null,
    val unpostedCurrentScore: Double? = null,
    val unpostedFinalScore: Double? = null,
    val unpostedCurrentPoints: Double? = null,
)

fun GradeEntity.translate(): Grade {
    return Grade(
        htmlUrl = htmlUrl,
        currentGrade = currentGrade,
        finalGrade = finalGrade,
        currentScore = currentScore,
        finalScore = finalScore,
        currentPoints = currentPoints,
        unpostedCurrentGrade = unpostedCurrentGrade,
        unpostedFinalGrade = unpostedFinalGrade,
        unpostedCurrentScore = unpostedCurrentScore,
        unpostedFinalScore = unpostedFinalScore,
    )
}
