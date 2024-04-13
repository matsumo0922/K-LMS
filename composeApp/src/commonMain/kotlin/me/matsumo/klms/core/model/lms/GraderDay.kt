package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.DayEntity

@Serializable
data class GraderDay(
    val date: String,
    val graders: List<Grader>,
)

fun DayEntity.translate(): GraderDay {
    return GraderDay(
        date = date,
        graders = graders.map { it.translate() },
    )
}
