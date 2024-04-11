package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseNickname(
        val courseId: Int,

        val name: String,

        val nickname: String
)

fun CourseNicknameEntity.translate(): CourseNickname {
    return CourseNickname(
        courseId = courseId,
        name = name
    )
}
