package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradeEntity(
    // The URL to the Canvas web UI page for the user's grades ...
    @SerialName("html_url")
    val htmlUrl: String,
    // The user's current grade in the class ...
    @SerialName("current_grade")
    val currentGrade: String? = null,
    // The user's final grade for the class ...
    @SerialName("final_grade")
    val finalGrade: String? = null,
    // The user's current score in the class ...
    @SerialName("current_score")
    val currentScore: Double? = null,
    // The user's final score for the class ...
    @SerialName("final_score")
    val finalScore: Double? = null,
    // The total points the user has earned in the class ...
    @SerialName("current_points")
    val currentPoints: Double? = null,
    // The user's current grade in the class including muted/unposted...
    @SerialName("unposted_current_grade")
    val unpostedCurrentGrade: String? = null,
    // The user's final grade for the class including muted/unposted ...
    @SerialName("unposted_final_grade")
    val unpostedFinalGrade: String? = null,
    // The user's current score in the class including muted/unposted ...
    @SerialName("unposted_current_score")
    val unpostedCurrentScore: Double? = null,
    // The user's final score for the class including muted/unposted ...
    @SerialName("unposted_final_score")
    val unpostedFinalScore: Double? = null,
    // The total points the user has earned in the class, including ...
    @SerialName("unposted_current_points")
    val unpostedCurrentPoints: Double? = null,
)
