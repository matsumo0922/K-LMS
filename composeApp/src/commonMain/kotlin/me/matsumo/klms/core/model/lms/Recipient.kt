package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipient(
    val id: String, 
    val name: String,

    val fullName: String?, 
    val type: String,

    val userCount: Int?,  
    val commonCourses: CourseEntity?, 
    val commonGroups:  GroupEntity? )

fun RecipientEntity.translate(): Recipient {
    return Recipient(
        id = id,
        name = name,
        fullName = fullName,
        type = type,
        userCount = userCount,
        commonCourses = commonCourses
    )
}
