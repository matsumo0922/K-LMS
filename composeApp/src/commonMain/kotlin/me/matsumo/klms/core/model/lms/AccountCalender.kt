package me.matsumo.klms.core.model.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountCalendarEntity

@Serializable
data class AccountCalender(
        val id: Int,
        val name: String,
        val parentAccountId: Int?,
        val rootAccountId: Int?,
        val visible: Boolean,
        val autoSubscribe: Boolean,
        val subAccountCount: Int,
        val assetString: String,
        val type: String,
        val calendarEventUrl: String,
        val canCreateCalendarEvents: Boolean,
        val createCalendarEventUrl: String,
        val newCalendarEventUrl: String
)

fun AccountCalendarEntity.translate(): AccountCalender {
    return AccountCalender(
        id = id,
        name = name,
        parentAccountId = parentAccountId,
        rootAccountId = rootAccountId,
        visible = visible,
        autoSubscribe = autoSubscribe,
        subAccountCount = subAccountCount,
        assetString = assetString,
        type = type,
        calendarEventUrl = calendarEventUrl,
        canCreateCalendarEvents = canCreateCalendarEvents,
        createCalendarEventUrl = createCalendarEventUrl,
        newCalendarEventUrl = newCalendarEventUrl
    )
}
