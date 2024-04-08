package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GraderEntity(
    // the user_id of the user who graded the contained submissions
    @SerialName("id")
    val id: Int,

    // the name of the user who graded the contained submissions
    @SerialName("name")
    val name: String,

    // the assignment groups for all submissions in this response that were graded ...
    @SerialName("assignments")
    val assignments: List<Int>
)
