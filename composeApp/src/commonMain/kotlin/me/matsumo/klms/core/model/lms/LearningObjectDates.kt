package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LearningObjectDates(
        val id: Int,

        val dueAt: String? = null,

        val lockAt: String? = null,

        val unlockAt: String? = null,

        val onlyVisibleToOverrides: Boolean,

        val blueprintDateLocks: List<String>,

        val visibleToEveryone: Boolean,

        val overrides: List<AssignmentOverrideEntity>? = null
)

fun LearningObjectDatesEntity.translate(): LearningObjectDates {
    return LearningObjectDates(
        id = id,
        dueAt = dueAt,
        lockAt = lockAt,
        unlockAt = unlockAt,
        onlyVisibleToOverrides = onlyVisibleToOverrides,
        blueprintDateLocks = blueprintDateLocks,
        visibleToEveryone = visibleToEveryone
    )
}
