package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.RecipientEntity

@Serializable
data class Recipient(
    val id: String,
    val name: String,
    val fullName: String?,
    val type: String,
    val userCount: Int?,
    val commonCourses: Course?,
    val commonGroups: Group?,
)

fun RecipientEntity.translate(): Recipient {
    return Recipient(
        id = id,
        name = name,
        fullName = fullName,
        type = type,
        userCount = userCount,
        commonCourses = commonCourses?.translate(),
        commonGroups = commonGroups?.translate(),
    )
}
