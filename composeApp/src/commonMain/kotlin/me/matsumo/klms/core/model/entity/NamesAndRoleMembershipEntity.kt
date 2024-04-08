package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMembershipEntity(
    @SerialName("status")
    val status: String,

    @SerialName("name")
    val name: String? = null, // Optional

    @SerialName("picture")
    val picture: String? = null, // Optional

    @SerialName("given_name")
    val givenName: String? = null, // Optional

    @SerialName("family_name")
    val familyName: String? = null, // Optional

    @SerialName("email")
    val email: String? = null, // Optional

    @SerialName("lis_person_sourcedid")
    val lisPersonSourcedid: String? = null, // Optional

    @SerialName("user_id")
    val userId: String,

    @SerialName("roles")
    val roles: List<String>,

    @SerialName("message")
    val message: List<Message>? = null  // Optional
) {

    @Serializable
    data class Message(
        @SerialName("https://purl.imsglobal.org/spec/lti/claim/message_type")
        val messageType: String,

        @SerialName("locale")
        val locale: String,

        @SerialName("https://www.instructure.com/canvas_user_id")
        val canvasUserId: Int,

        @SerialName("https://www.instructure.com/canvas_user_login_id")
        val canvasUserLoginId: String,

        @SerialName("https://purl.imsglobal.org/spec/lti/claim/custom")
        val custom: CustomParameters
    )

    @Serializable
    data class CustomParameters(
        @SerialName("message_locale")
        val messageLocale: String,

        @SerialName("person_address_timezone")
        val personAddressTimezone: String
    )
}
