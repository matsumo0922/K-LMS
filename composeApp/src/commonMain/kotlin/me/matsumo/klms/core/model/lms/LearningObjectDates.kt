package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LearningObjectDatesEntity

@Serializable
data class LearningObjectDates(
    val id: Int,
    val dueAt: Instant? = null,
    val lockAt: Instant? = null,
    val unlockAt: Instant? = null,
    val onlyVisibleToOverrides: Boolean,
    val blueprintDateLocks: List<String>,
    val visibleToEveryone: Boolean,
    val overrides: List<AssignmentOverride>? = null,
)

fun LearningObjectDatesEntity.translate(): LearningObjectDates {
    return LearningObjectDates(
        id = id,
        dueAt = dueAt?.let { Instant.parse(it) },
        lockAt = lockAt?.let { Instant.parse(it) },
        unlockAt = unlockAt?.let { Instant.parse(it) },
        onlyVisibleToOverrides = onlyVisibleToOverrides,
        blueprintDateLocks = blueprintDateLocks,
        visibleToEveryone = visibleToEveryone,
        overrides = overrides?.map { it.translate() },
    )
}
