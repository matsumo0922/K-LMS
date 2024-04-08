package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CalendarLinkEntity(
    // The URL of the calendar in ICS format
    @SerialName("ics")
    val ics: String
)
