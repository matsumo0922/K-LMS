package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomColumn(
        val id: Int,

        val teacherNotes: Boolean,

        val title: String,

        val position: Int,

        val hidden: Boolean,

        val readOnly: Boolean
)

fun CustomColumnEntity.translate(): CustomColumn {
    return CustomColumn(
        id = id,
        teacherNotes = teacherNotes,
        title = title,
        position = position,
        hidden = hidden
    )
}
