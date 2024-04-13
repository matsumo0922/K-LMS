package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.TermEntity

@Serializable
data class Term(
    val id: Int,
    val name: String,
    val startAt: String,
    val endAt: String? = null,
)

fun TermEntity.translate(): Term {
    return Term(
        id = id,
        name = name,
        startAt = startAt,
        endAt = endAt,
    )
}
