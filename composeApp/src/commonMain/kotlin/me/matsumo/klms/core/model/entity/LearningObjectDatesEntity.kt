package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class LearningObjectDatesEntity(
    // the ID of the learning object
    @SerialName("id")
    val id: Int,

    // the due date for the learning object...
    @SerialName("due_at")
    val dueAt: String? = null,

    // the lock date ...
    @SerialName("lock_at")
    val lockAt: String? = null,

    // the unlock date ...
    @SerialName("unlock_at")
    val unlockAt: String? = null,

    // whether the learning object is only visible to overrides
    @SerialName("only_visible_to_overrides")
    val onlyVisibleToOverrides: Boolean,

    // [exclusive to blueprint child content only] ...
    @SerialName("blueprint_date_locks")
    val blueprintDateLocks: List<String>,

    // whether the learning object is visible to everyone
    @SerialName("visible_to_everyone")
    val visibleToEveryone: Boolean,

    // paginated list of AssignmentOverride objects
    @SerialName("overrides")
    val overrides: List<AssignmentOverrideEntity>? = null
)
