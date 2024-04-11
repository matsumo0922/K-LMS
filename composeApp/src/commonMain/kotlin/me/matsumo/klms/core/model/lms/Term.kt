package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Term(
    val id: Int,

    val name: String,

    val startAt: String,

    val endAt: String? = null
)

fun TermEntity.translate(): Term {
    return Term(
        id = id,
        name = name,
        startAt = startAt
    )
}
