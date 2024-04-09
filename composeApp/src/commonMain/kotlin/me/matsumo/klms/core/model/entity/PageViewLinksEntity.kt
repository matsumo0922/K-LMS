package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageViewLinksEntity(
    // The ID of the user for this page view
    @SerialName("user")
    val user: Int,

    // The ID of the context for the request
    @SerialName("context")
    val context: Int,

    // The ID of the asset for the request, if any
    @SerialName("asset")
    val asset: Int?,

    //  The ID of the actual user who made this request (if masquerading)
    @SerialName("real_user")
    val realUser: Int?,

    // The ID of the account context for this page view
    @SerialName("account")
    val account: Int
)
