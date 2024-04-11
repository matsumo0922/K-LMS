package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageViewLinks(
        val user: Int,

        val context: Int,

        val asset: Int?,

        val realUser: Int?,

        val account: Int
)

fun PageViewLinksEntity.translate(): PageViewLinks {
    return PageViewLinks(
        user = user,
        context = context,
        asset = asset,
        realUser = realUser
    )
}
