package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseProgress(
        val requirementCount: Int,

        val requirementCompletedCount: Int,

        val nextRequirementUrl: String? = null,

        val completedAt: String? = null
)

fun CourseProgressEntity.translate(): CourseProgress {
    return CourseProgress(
        requirementCount = requirementCount,
        requirementCompletedCount = requirementCompletedCount,
        nextRequirementUrl = nextRequirementUrl
    )
}
