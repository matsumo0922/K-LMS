package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseProgressEntity

@Serializable
data class CourseProgress(
    val requirementCount: Int,
    val requirementCompletedCount: Int,
    val nextRequirementUrl: String? = null,
    val completedAt: String? = null,
)

fun CourseProgressEntity.translate(): CourseProgress {
    return CourseProgress(
        requirementCount = requirementCount,
        requirementCompletedCount = requirementCompletedCount,
        nextRequirementUrl = nextRequirementUrl,
    )
}
