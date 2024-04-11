package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GradingStandard(
        val title: String,

        val id: Int,

        val contextType: String,

        val contextId: Int,

        val gradingScheme: List<GradingSchemeEntryEntity>
)


fun GradingStandardEntity.translate(): GradingStandard {
    return GradingStandard(
        title = title,
        id = id,
        contextType = contextType,
        contextId = contextId
    )
}
