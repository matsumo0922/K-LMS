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
    val createdAt: Instant,
    val endDate: Instant,
    val updatedAt: Instant,
    val publishedAt: Instant,
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
        createdAt = Instant.parse(createdAt),
        endDate = Instant.parse(endDate),
        updatedAt = Instant.parse(updatedAt),
        publishedAt = Instant.parse(publishedAt),
        rootAccountId = rootAccountId,
        startDate = Instant.parse(startDate),
        modules = modules?.map { it.translate() } ?: emptyList(),
        progress = progress?.translate(),
    )
}
