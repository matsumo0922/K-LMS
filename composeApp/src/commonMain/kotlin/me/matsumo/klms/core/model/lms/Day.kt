package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Day(
        val date: String,

        val graders: List<GraderEntity>
)


fun DayEntity.translate(): Day {
    return Day(
        date = date
    )
}
