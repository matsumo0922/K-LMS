package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingPeriodEntity(
    // The unique identifier for the grading period.
    @SerialName("id")
    val id: Int,

    // The title for the grading period.
    @SerialName("title")
    val title: String,

    // The start date of the grading period.
    @SerialName("start_date")
    val startDate: String,

    // The end date of the grading period.
    @SerialName("end_date")
    val endDate: String,

    // Grades can only be changed before the close date ...
    @SerialName("close_date")
    val closeDate: String,

    // A weight value that contributes to the overall weight ...
    @SerialName("weight")
    val weight: Double,

    // If true, the grading period's close_date has passed.
    @SerialName("is_closed")
    val isClosed: Boolean
)
