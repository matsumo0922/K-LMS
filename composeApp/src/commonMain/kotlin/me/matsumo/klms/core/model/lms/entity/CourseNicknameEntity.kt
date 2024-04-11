package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseNicknameEntity(
    // The ID of the course
    @SerialName("course_id")
    val courseId: Int,

    // The actual name of the course
    @SerialName("name")
    val name: String,

    // The user's nickname for the course
    @SerialName("nickname")
    val nickname: String
)
