package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LearningObjectDatesEntity

@Serializable
data class LearningObjectDates(
    val id: Int,
    val dueAt: String? = null,
    val lockAt: String? = null,
    val unlockAt: String? = null,
    val onlyVisibleToOverrides: Boolean,
    val blueprintDateLocks: List<String>,
    val visibleToEveryone: Boolean,
    val overrides: List<AssignmentOverride>? = null,
)

fun LearningObjectDatesEntity.translate(): LearningObjectDates {
    return LearningObjectDates(
        id = id,
        dueAt = dueAt,
        lockAt = lockAt,
        unlockAt = unlockAt,
        onlyVisibleToOverrides = onlyVisibleToOverrides,
        blueprintDateLocks = blueprintDateLocks,
        visibleToEveryone = visibleToEveryone,
        overrides = overrides?.map { it.translate() },
    )
}
