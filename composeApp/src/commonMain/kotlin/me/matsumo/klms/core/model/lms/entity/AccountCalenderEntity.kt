package me.matsumo.klms.core.model.lms.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountCalendarEntity(
    // the ID of the account associated with this calendar
    @SerialName("id") val id: Int,
    // the name of the account associated with this calendar
    @SerialName("name") val name: String,
    // the account's parent ID, or null if this is the root account
    @SerialName("parent_account_id") val parentAccountId: Int?,
    // the ID of the root account, or null if this is the root account
    @SerialName("root_account_id") val rootAccountId: Int?,
    // whether this calendar is visible to users
    @SerialName("visible") val visible: Boolean,
    // whether users see this calendar's events without needing to manually add it
    @SerialName("auto_subscribe") val autoSubscribe: Boolean,
    // number of this account's direct sub-accounts
    @SerialName("sub_account_count") val subAccountCount: Int,
    // Asset string of the account
    @SerialName("asset_string") val assetString: String,
    // Object type
    @SerialName("type") val type: String,
    // url to get full detailed events
    @SerialName("calendar_event_url") val calendarEventUrl: String,
    // whether the user can create calendar events
    @SerialName("can_create_calendar_events") val canCreateCalendarEvents: Boolean,
    // API path to create events for the account
    @SerialName("create_calendar_event_url") val createCalendarEventUrl: String,
    // url to open the more options event editor
    @SerialName("new_calendar_event_url") val newCalendarEventUrl: String
)
