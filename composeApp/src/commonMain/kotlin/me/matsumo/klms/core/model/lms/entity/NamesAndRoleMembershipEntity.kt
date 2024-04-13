package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMembershipEntity(
    @SerialName("email")
    val email: String,
    @SerialName("family_name")
    val familyName: String,
    @SerialName("given_name")
    val givenName: String,
    @SerialName("lis_person_sourcedid")
    val lisPersonSourcedid: String,
    @SerialName("message")
    val message: List<Message>,
    @SerialName("name")
    val name: String,
    @SerialName("picture")
    val picture: String,
    @SerialName("roles")
    val roles: List<String>,
    @SerialName("status")
    val status: String,
    @SerialName("user_id")
    val userId: String,
) {
    @Serializable
    data class Message(
        @SerialName("custom")
        val custom: Custom,
        @SerialName("message_type")
        val messageType: String,
        @SerialName("canvas_user_id")
        val canvasUserId: Int,
        @SerialName("canvas_user_login_id")
        val canvasUserLoginId: String,
        @SerialName("locale")
        val locale: String,
    ) {
        @Serializable
        data class Custom(
            @SerialName("message_locale")
            val messageLocale: String,
            @SerialName("person_address_timezone")
            val personAddressTimezone: String,
        )
    }
}
