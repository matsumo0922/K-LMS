package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
        val id: String,

        val passed: Boolean,

        val assessedAt: String,

        val links: ResultLinksEntity
)


fun ResultEntity.translate(): Result {
    return Result(
        id = id,
        passed = passed,
        assessedAt = assessedAt
    )
}
