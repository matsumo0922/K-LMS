package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ResultLinksEntity

@Serializable
data class ResultLinks(
    val user: String,
    val assessor: String,
    val assessment: String,
)

fun ResultLinksEntity.translate(): ResultLinks {
    return ResultLinks(
        user = user,
        assessor = assessor,
        assessment = assessment,
    )
}
