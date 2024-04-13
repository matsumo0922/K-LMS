package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NamesAndRoleMembershipsEntity(
    @SerialName("context")
    val context: Context,
    @SerialName("id")
    val id: String,
    @SerialName("members")
    val members: List<NamesAndRoleMembershipEntity>,
) {
    @Serializable
    data class Context(
        @SerialName("id")
        val id: String,
        @SerialName("label")
        val label: String,
        @SerialName("title")
        val title: String,
    )
}
