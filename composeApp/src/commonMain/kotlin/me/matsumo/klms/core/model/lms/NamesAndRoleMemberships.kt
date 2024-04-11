package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMemberships(
        val id: String,

        val context: Context,

        val members: List<NamesAndRoleMembership>
) {
    @Serializable
    data class Context(
        val id: String,

        val label: String,

        val title: String
    )

    @Serializable
    data class NamesAndRoleMembership(
        val status: String,

        val name: String,

        val picture: String,

        val givenName: String,

        val familyName: String,

        val email: String,

        val lisPersonSourcedid: String,

        val userId: String,

        val roles: List<String>,

        val message: List<Message>
    )

    @Serializable
    data class Message(
                @SerialName("https:        val messageType: String,

        val locale: String,

        @SerialName("https:        val canvasUserId: Int,

        @SerialName("https:        val canvasUserLoginId: String,

            )
}

fun NamesAndRoleMembershipsEntity.translate(): NamesAndRoleMemberships {
    return NamesAndRoleMemberships(
        id = id,
        context = context,
        id = id,
        label = label,
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
        canvasUserLoginId = canvasUserLoginId
    )
}
