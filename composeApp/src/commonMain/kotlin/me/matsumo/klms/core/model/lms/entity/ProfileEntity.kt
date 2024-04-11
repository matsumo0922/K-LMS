package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileEntity(
    //  The ID of the user.
    @SerialName("id")
    val id: Int,

    // Sample User
    @SerialName("name")
    val name: String,

    // Sample User
    @SerialName("short_name")
    val shortName: String,

    // user, sample
    @SerialName("sortable_name")
    val sortableName: String,

    // User title
    @SerialName("title")
    val title: String?,

    // User bio
    @SerialName("bio")
    val bio: String?,

    // sample_user@example.com
    @SerialName("primary_email")
    val primaryEmail: String,

    // sample_user@example.com
    @SerialName("login_id")
    val loginId: String,

    // sis1
    @SerialName("sis_user_id")
    val sisUserId: String?,

    // User's LTI ID (if applicable)
    @SerialName("lti_user_id")
    val ltiUserId: String?,

    // ..url..
    @SerialName("avatar_url")
    val avatarUrl: String,

    // Calendar details - Placeholder
    @SerialName("calendar")
    val calendar: me.matsumo.klms.core.model.lms.entity.CalendarEventEntity?,

    // Optional: The user's preferred timezone
    @SerialName("time_zone")
    val timeZone: String?,

    // User's locale
    @SerialName("locale")
    val locale: String?,

    // Optional: Whether the user is a K5 user
    @SerialName("k5_user")
    val k5User: Boolean?,

    // Optional: Whether to use classic font on dashboard (if K5 user)
    @SerialName("use_classic_font_in_k5")
    val useClassicFontInK5: Boolean?
)
