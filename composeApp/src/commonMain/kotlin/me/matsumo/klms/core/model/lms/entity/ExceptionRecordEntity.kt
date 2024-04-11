package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Lists associated courses that did not receive a change propagated from a blueprint.
@Serializable
data class ExceptionRecordEntity(
    // The ID of the associated course
    @SerialName("course_id") val courseId: Int,
    // A list of change classes in the associated course's copy of the item that prevented a blueprint change from being applied.
    @SerialName("conflicting_changes") val conflictingChanges: List<String>
)
