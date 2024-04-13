package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseNicknameEntity

@Serializable
data class CourseNickname(
    val courseId: Int,
    val name: String,
    val nickname: String,
)

fun CourseNicknameEntity.translate(): CourseNickname {
    return CourseNickname(
        courseId = courseId,
        name = name,
        nickname = nickname,
    )
}
