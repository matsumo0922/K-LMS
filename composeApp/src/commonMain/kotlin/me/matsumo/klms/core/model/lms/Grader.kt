package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GraderEntity

@Serializable
data class Grader(
    val id: Int,
    val name: String,
    val assignments: List<Int>,
)

fun GraderEntity.translate(): Grader {
    return Grader(
        id = id,
        name = name,
        assignments = assignments,
    )
}
