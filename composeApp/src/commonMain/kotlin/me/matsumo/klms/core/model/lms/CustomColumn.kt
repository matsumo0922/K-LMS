package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CustomColumnEntity

@Serializable
data class CustomColumn(
    val id: Int,
    val teacherNotes: Boolean,
    val title: String,
    val position: Int,
    val hidden: Boolean,
    val readOnly: Boolean,
)

fun CustomColumnEntity.translate(): CustomColumn {
    return CustomColumn(
        id = id,
        teacherNotes = teacherNotes,
        title = title,
        position = position,
        hidden = hidden,
        readOnly = readOnly,
    )
}
