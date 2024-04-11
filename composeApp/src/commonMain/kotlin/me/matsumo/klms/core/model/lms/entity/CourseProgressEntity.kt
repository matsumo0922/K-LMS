package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseProgressEntity(
    // total number of requirements from all modules
    @SerialName("requirement_count")
    val requirementCount: Int,

    // total number of requirements the user has completed from ...
    @SerialName("requirement_completed_count")
    val requirementCompletedCount: Int,

    // url to next module item that has an unmet requirement. ...
    @SerialName("next_requirement_url")
    val nextRequirementUrl: String? = null,

    // date the course was completed. ...
    @SerialName("completed_at")
    val completedAt: String? = null
)
