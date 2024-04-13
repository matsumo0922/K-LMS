package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PageViewLinksEntity

@Serializable
data class PageViewLinks(
    val user: Int,
    val context: Int,
    val asset: Int?,
    val realUser: Int?,
    val account: Int,
)

fun PageViewLinksEntity.translate(): PageViewLinks {
    return PageViewLinks(
        user = user,
        context = context,
        asset = asset,
        realUser = realUser,
        account = account,
    )
}
