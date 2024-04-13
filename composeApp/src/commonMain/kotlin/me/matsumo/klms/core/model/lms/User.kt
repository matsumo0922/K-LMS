package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.UserEntity

@Serializable
data class User(
    val id: Int,
    val name: String,
    val sortableName: String,
    val lastName: String,
    val firstName: String,
    val shortName: String,
    val sisUserId: String?,
    val sisImportId: Int?,
    val integrationId: String?,
    val loginId: String,
    val avatarUrl: String,
    val avatarState: String?,
    val enrollments: List<Enrollment>?,
    val email: String?,
    val locale: String?,
    val lastLogin: String?,
    val timeZone: String?,
    val bio: String?,
)

fun UserEntity.translate(): User {
    return User(
        id = id,
        name = name,
        sortableName = sortableName,
        lastName = lastName,
        firstName = firstName,
        shortName = shortName,
        sisUserId = sisUserId,
        sisImportId = sisImportId,
        integrationId = integrationId,
        loginId = loginId,
        avatarUrl = avatarUrl,
        avatarState = avatarState,
        enrollments = enrollments?.map { it.translate() },
        email = email,
        locale = locale,
        lastLogin = lastLogin,
        timeZone = timeZone,
        bio = bio,
    )
}
