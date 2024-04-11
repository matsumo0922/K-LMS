package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMembership(
    val status: String,

    val name: String? = null, 
    val picture: String? = null, 
    val givenName: String? = null, 
    val familyName: String? = null, 
    val email: String? = null, 
    val lisPersonSourcedid: String? = null, 
    val userId: String,

    val roles: List<String>,

    val message: List<Message>? = null  ) {

    @Serializable
    data class Message(
        @SerialName("https:        val messageType: String,

        val locale: String,

        @SerialName("https:        val canvasUserId: Int,

        @SerialName("https:        val canvasUserLoginId: String,

        @SerialName("https:        val custom: CustomParameters
    )

    @Serializable
    data class CustomParameters(
        val messageLocale: String,

        val personAddressTimezone: String
    )
}

fun NamesAndRoleMembershipEntity.translate(): NamesAndRoleMembership {
    return NamesAndRoleMembership(
        status = status,
        name = name,
        picture = picture,
        givenName = givenName,
        familyName = familyName,
        email = email,
        lisPersonSourcedid = lisPersonSourcedid,
        userId = userId,
        roles = roles,
        messageType = messageType,
        locale = locale,
        canvasUserId = canvasUserId,
        canvasUserLoginId = canvasUserLoginId,
        messageLocale = messageLocale
    )
}
