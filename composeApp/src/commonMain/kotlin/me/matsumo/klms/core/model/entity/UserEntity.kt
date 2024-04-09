package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    // The ID of the user.
    @SerialName("id")
    val id: Int,

    // The name of the user.
    @SerialName("name")
    val name: String,

    // The name to use for sorting
    @SerialName("sortable_name")
    val sortableName: String,

    // Last name
    @SerialName("last_name")
    val lastName: String,

    // First name
    @SerialName("first_name")
    val firstName: String,

    // Short name
    @SerialName("short_name")
    val shortName: String,

    // SIS User ID (if permissions allow)
    @SerialName("sis_user_id")
    val sisUserId: String?,

    // SIS import ID (if permissions allow)
    @SerialName("sis_import_id")
    val sisImportId: Int?,

    // Integration ID (if permissions allow)
    @SerialName("integration_id")
    val integrationId: String?,

    // Login ID
    @SerialName("login_id")
    val loginId: String,

    // Avatar URL (if enabled)
    @SerialName("avatar_url")
    val avatarUrl: String,

    // Avatar state (optional, if admin)
    @SerialName("avatar_state")
    val avatarState: String?,

    // List of enrollments (optional)
    @SerialName("enrollments")
    val enrollments: List<EnrollmentEntity>?,

    // Primary email (optional)
    @SerialName("email")
    val email: String?,

    // User's locale (optional)
    @SerialName("locale")
    val locale: String?,

    // Last login time (optional)
    @SerialName("last_login")
    val lastLogin: String?,

    // User's timezone (optional)
    @SerialName("time_zone")
    val timeZone: String?,

    // User bio (optional)
    @SerialName("bio")
    val bio: String?
)
