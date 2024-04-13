package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomColumnEntity(
    // The ID of the custom gradebook column
    @SerialName("id")
    val id: Int,
    // When true, this column's visibility ...
    @SerialName("teacher_notes")
    val teacherNotes: Boolean,
    // header text
    @SerialName("title")
    val title: String,
    // column order
    @SerialName("position")
    val position: Int,
    // won't be displayed if hidden is true
    @SerialName("hidden")
    val hidden: Boolean,
    // won't be editable in the gradebook UI
    @SerialName("read_only")
    val readOnly: Boolean,
)
