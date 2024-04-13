package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.NamesAndRoleMembershipEntity

@Serializable
data class NamesAndRoleMembership(
    val email: String,
    val familyName: String,
    val givenName: String,
    val lisPersonSourcedid: String,
    val message: List<Message>,
    val name: String,
    val picture: String,
    val roles: List<String>,
    val status: String,
    val userId: String,
) {
    @Serializable
    data class Message(
        val custom: Custom,
        val messageType: String,
        val canvasUserId: Int,
        val canvasUserLoginId: String,
        val locale: String,
    ) {
        @Serializable
        data class Custom(
            val messageLocale: String,
            val personAddressTimezone: String,
        )
    }
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
        message = message.map {
            NamesAndRoleMembership.Message(
                messageType = it.messageType,
                canvasUserId = it.canvasUserId,
                canvasUserLoginId = it.canvasUserLoginId,
                locale = it.locale,
                custom = NamesAndRoleMembership.Message.Custom(
                    messageLocale = it.custom.messageLocale,
                    personAddressTimezone = it.custom.personAddressTimezone,
                ),
            )
        },
    )
}
