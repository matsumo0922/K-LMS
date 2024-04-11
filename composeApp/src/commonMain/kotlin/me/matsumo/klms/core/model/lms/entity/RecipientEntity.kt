package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipientEntity(
    @SerialName("id")
    val id: String, // Could be either a number or a string

    @SerialName("name")
    val name: String,

    @SerialName("full_name")
    val fullName: String?, // Assuming this can be optional

    @SerialName("type")
    val type: String,

    @SerialName("user_count")
    val userCount: Int?,  // Assuming user count is optional for groups

    @SerialName("common_courses")
    val commonCourses: me.matsumo.klms.core.model.lms.entity.CourseEntity?, // Placeholder

    @SerialName("common_groups")
    val commonGroups:  me.matsumo.klms.core.model.lms.entity.GroupEntity? // Placeholder
)
