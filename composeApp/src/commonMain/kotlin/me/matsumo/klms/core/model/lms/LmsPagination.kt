package me.matsumo.klms.core.model.lms

import io.ktor.http.Headers

data class LmsPagination(
    val current: String?,
    val next: String?,
    val previous: String?,
    val first: String?,
    val last: String?,
)

data class Paging <out T> (
    val data: T,
    val pagination: LmsPagination,
)

fun Headers.getLmsPagination(): LmsPagination {
    var pagination = LmsPagination(null, null, null, null, null)

    val links = this["Link"] ?: return pagination
    val items = links.split(",").map { it.trim() }

    for (item in items) {
        val parts = item.split(";")
        val url = parts[0].trim().removePrefix("<").removeSuffix(">")
        val rel = parts[1].trim().removePrefix("rel=\"").removeSuffix("\"")

        pagination = when (rel) {
            "current" -> pagination.copy(current = url)
            "next" -> pagination.copy(next = url)
            "previous" -> pagination.copy(previous = url)
            "first" -> pagination.copy(first = url)
            "last" -> pagination.copy(last = url)
            else -> pagination
        }
    }

    return pagination
}
