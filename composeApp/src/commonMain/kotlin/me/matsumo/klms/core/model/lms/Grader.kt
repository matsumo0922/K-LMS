package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Grader(
        val id: Int,

        val name: String,

        val assignments: List<Int>
)

fun GraderEntity.translate(): Grader {
    return Grader(
        id = id,
        name = name
    )
}
