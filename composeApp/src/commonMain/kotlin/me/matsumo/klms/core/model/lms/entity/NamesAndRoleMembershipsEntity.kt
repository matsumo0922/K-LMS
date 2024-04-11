package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMembershipsEntity(
    // Invocation URL
    @SerialName("id")
    val id: String,

    // The LTI Context ...
    @SerialName("context")
    val context: me.matsumo.klms.core.model.lms.entity.NamesAndRoleMembershipsEntity.Context,

    // A list of NamesAndRoleMembership
    @SerialName("members")
    val members: List<me.matsumo.klms.core.model.lms.entity.NamesAndRoleMembershipsEntity.NamesAndRoleMembership>
) {
    @Serializable
    data class Context(
        @SerialName("id")
        val id: String,

        @SerialName("label")
        val label: String,

        @SerialName("title")
        val title: String
    )

    @Serializable
    data class NamesAndRoleMembership(
        @SerialName("status")
        val status: String,

        @SerialName("name")
        val name: String,

        @SerialName("picture")
        val picture: String,

        @SerialName("given_name")
        val givenName: String,

        @SerialName("family_name")
        val familyName: String,

        @SerialName("email")
        val email: String,

        @SerialName("lis_person_sourcedid")
        val lisPersonSourcedid: String,

        @SerialName("user_id")
        val userId: String,

        @SerialName("roles")
        val roles: List<String>,

        @SerialName("message")
        val message: List<me.matsumo.klms.core.model.lms.entity.NamesAndRoleMembershipsEntity.Message>
    )

    @Serializable
    data class Message(
        // I assume there are more fields under these namespaces
        @SerialName("https://purl.imsglobal.org/spec/lti/claim/message_type")
        val messageType: String,

        @SerialName("locale")
        val locale: String,

        @SerialName("https://www.instructure.com/canvas_user_id")
        val canvasUserId: Int,

        @SerialName("https://www.instructure.com/canvas_user_login_id")
        val canvasUserLoginId: String,

        // Add fields for any custom parameters (assuming some exist)
    )
}
