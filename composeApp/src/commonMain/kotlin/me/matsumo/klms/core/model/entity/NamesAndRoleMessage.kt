package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class NamesAndRoleMessage(
    @SerialName("https://purl.imsglobal.org/spec/lti/claim/message_type")
    val messageType: String, // Always 'LtiResourceLinkRequest'

    @SerialName("locale")
    val locale: String,

    @SerialName("https://www.instructure.com/canvas_user_id")
    val canvasUserId: Int,

    @SerialName("https://www.instructure.com/canvas_user_login_id")
    val canvasUserLoginId: String,

    @SerialName("https://purl.imsglobal.org/spec/lti/claim/custom")
    val custom: CustomParameters
) {
    @Serializable
    data class CustomParameters(
        @SerialName("message_locale")
        val messageLocale: String,

        @SerialName("person_address_timezone")
        val personAddressTimezone: String
    )
}
