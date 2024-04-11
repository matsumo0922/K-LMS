package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LatePolicyEntity(
    // the unique identifier for the late policy
    @SerialName("id")
    val id: Int,

    // the unique identifier for the course
    @SerialName("course_id")
    val courseId: Int,

    // whether to enable missing submission deductions
    @SerialName("missing_submission_deduction_enabled")
    val missingSubmissionDeductionEnabled: Boolean,

    // amount of percentage points to deduct
    @SerialName("missing_submission_deduction")
    val missingSubmissionDeduction: Double,

    // whether to enable late submission deductions
    @SerialName("late_submission_deduction_enabled")
    val lateSubmissionDeductionEnabled: Boolean,

    // amount of percentage points to deduct per late_submission_interval
    @SerialName("late_submission_deduction")
    val lateSubmissionDeduction: Double,

    // time interval for late submission deduction
    @SerialName("late_submission_interval")
    val lateSubmissionInterval: String,

    // whether to enable late submission minimum percent
    @SerialName("late_submission_minimum_percent_enabled")
    val lateSubmissionMinimumPercentEnabled: Boolean,

    // the minimum score a submission can receive in percentage points
    @SerialName("late_submission_minimum_percent")
    val lateSubmissionMinimumPercent: Double,

    // the time at which this late policy was originally created
    @SerialName("created_at")
    val createdAt: String,

    // the time at which this late policy was last modified in any way
    @SerialName("updated_at")
    val updatedAt: String
)
