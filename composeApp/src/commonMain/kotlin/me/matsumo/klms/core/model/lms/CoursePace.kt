package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CoursePaceEntity

@Serializable
data class CoursePace(
    val id: Int,
    val courseId: Int,
    val userId: Int,
    val workflowState: String,
    val excludeWeekends: Boolean,
    val hardEndDates: Boolean,
    val createdAt: String,
    val endDate: Instant,
    val updatedAt: String,
    val publishedAt: String,
    val rootAccountId: Int,
    val startDate: Instant,
    val modules: List<LmsModule> = emptyList(),
    val progress: LmsProgress? = null,
)

fun CoursePaceEntity.translate(): CoursePace {
    return CoursePace(
        id = id,
        courseId = courseId,
        userId = userId,
        workflowState = workflowState,
        excludeWeekends = excludeWeekends,
        hardEndDates = hardEndDates,
        createdAt = createdAt,
        endDate = Instant.parse(endDate),
        updatedAt = updatedAt,
        publishedAt = publishedAt,
        rootAccountId = rootAccountId,
        startDate = Instant.parse(startDate),
        modules = modules?.map { it.translate() } ?: emptyList(),
        progress = progress?.translate(),
    )
}
