package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LatePolicyEntity

@Serializable
data class LatePolicy(
    val id: Int,
    val courseId: Int,
    val missingSubmissionDeductionEnabled: Boolean,
    val missingSubmissionDeduction: Double,
    val lateSubmissionDeductionEnabled: Boolean,
    val lateSubmissionDeduction: Double,
    val lateSubmissionInterval: String,
    val lateSubmissionMinimumPercentEnabled: Boolean,
    val lateSubmissionMinimumPercent: Double,
    val createdAt: Instant,
    val updatedAt: Instant,
)

fun LatePolicyEntity.translate(): LatePolicy {
    return LatePolicy(
        id = id,
        courseId = courseId,
        missingSubmissionDeductionEnabled = missingSubmissionDeductionEnabled,
        missingSubmissionDeduction = missingSubmissionDeduction,
        lateSubmissionDeductionEnabled = lateSubmissionDeductionEnabled,
        lateSubmissionDeduction = lateSubmissionDeduction,
        lateSubmissionInterval = lateSubmissionInterval,
        lateSubmissionMinimumPercentEnabled = lateSubmissionMinimumPercentEnabled,
        lateSubmissionMinimumPercent = lateSubmissionMinimumPercent,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
    )
}
