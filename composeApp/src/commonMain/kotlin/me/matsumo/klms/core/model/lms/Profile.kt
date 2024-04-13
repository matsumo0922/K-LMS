package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ProfileEntity

@Serializable
data class Profile(
    val id: Int,
    val name: String,
    val shortName: String,
    val sortableName: String,
    val title: String?,
    val bio: String?,
    val primaryEmail: String,
    val loginId: String,
    val sisUserId: String?,
    val ltiUserId: String?,
    val avatarUrl: String,
    val calendar: CalendarEvent?,
    val timeZone: String?,
    val locale: String?,
    val k5User: Boolean?,
    val useClassicFontInK5: Boolean?,
)

fun ProfileEntity.translate(): Profile {
    return Profile(
        id = id,
        name = name,
        shortName = shortName,
        sortableName = sortableName,
        title = title,
        bio = bio,
        primaryEmail = primaryEmail,
        loginId = loginId,
        sisUserId = sisUserId,
        ltiUserId = ltiUserId,
        avatarUrl = avatarUrl,
        calendar = calendar?.translate(),
        timeZone = timeZone,
        locale = locale,
        k5User = k5User,
        useClassicFontInK5 = useClassicFontInK5,
    )
}
