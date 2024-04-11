package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultLinks(
        val user: String,

        val assessor: String,

        val assessment: String
)

fun ResultLinksEntity.translate(): ResultLinks {
    return ResultLinks(
        user = user,
        assessor = assessor
    )
}
