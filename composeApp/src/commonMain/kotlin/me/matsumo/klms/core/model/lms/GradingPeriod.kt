package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradingPeriodEntity

@Serializable
data class GradingPeriod(
    val id: Int,
    val title: String,
    val startDate: Instant,
    val endDate: Instant,
    val closeDate: Instant,
    val weight: Double,
    val isClosed: Boolean,
)

fun GradingPeriodEntity.translate(): GradingPeriod {
    return GradingPeriod(
        id = id,
        title = title,
        startDate = Instant.parse(startDate),
        endDate = Instant.parse(endDate),
        closeDate = Instant.parse(closeDate),
        weight = weight,
        isClosed = isClosed,
    )
}
