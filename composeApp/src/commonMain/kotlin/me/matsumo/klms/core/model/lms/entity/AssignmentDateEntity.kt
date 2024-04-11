package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssignmentDateEntity(
    // (Optional, missing if 'base' is present) id of the assignment override this date represents
    @SerialName("id") val id: Int?,
    // (Optional, present if 'id' is missing) whether this date represents the assignment's or quiz's default due date
    @SerialName("base") val base: Boolean?,
    // Title associated with the assignment date
    @SerialName("title") val title: String,
    // The due date for the assignment. Must be between the unlock date and the lock date if there are lock dates
    @SerialName("due_at") val dueAt: String,
    // The unlock date for the assignment. Must be before the due date if there is a due date.
    @SerialName("unlock_at") val unlockAt: String,
    // The lock date for the assignment. Must be after the due date if there is a due date.
    @SerialName("lock_at") val lockAt: String
)
