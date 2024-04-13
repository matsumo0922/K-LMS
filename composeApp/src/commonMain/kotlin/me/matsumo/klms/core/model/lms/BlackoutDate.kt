package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlackoutDateEntity

@Serializable
data class BlackoutDate(
    val id: Int,
    val contextId: Int,
    val contextType: String,
    val startDate: Instant,
    val endDate: Instant,
    val eventTitle: String,
)

fun BlackoutDateEntity.translate(): BlackoutDate {
    return BlackoutDate(
        id = id,
        contextId = contextId,
        contextType = contextType,
        startDate = Instant.parse(startDate),
        endDate = Instant.parse(endDate),
        eventTitle = eventTitle,
    )
}
