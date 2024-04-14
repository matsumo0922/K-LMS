package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.TermEntity

@Serializable
data class LmsTerm(
    val id: Int,
    val name: String,
    val startAt: Instant,
    val endAt: Instant? = null,
)

fun TermEntity.translate(): LmsTerm {
    return LmsTerm(
        id = id,
        name = name,
        startAt = Instant.parse(startAt),
        endAt = endAt?.let { Instant.parse(it) },
    )
}
