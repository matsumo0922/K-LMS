package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CalendarLinkEntity

@Serializable
data class CalendarLink(
    val ics: String,
)

fun CalendarLinkEntity.translate(): CalendarLink {
    return CalendarLink(
        ics = ics,
    )
}
