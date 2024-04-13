package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradingStandardEntity

@Serializable
data class GradingStandard(
    val title: String,
    val id: Int,
    val contextType: String,
    val contextId: Int,
    val gradingScheme: List<GradingScheme>,
) {
    @Serializable
    data class GradingScheme(
        val name: String,
        val value: Double,
    )
}

fun GradingStandardEntity.translate(): GradingStandard {
    return GradingStandard(
        title = title,
        id = id,
        contextType = contextType,
        contextId = contextId,
        gradingScheme = gradingScheme.map {
            GradingStandard.GradingScheme(
                name = it.name,
                value = it.value,
            )
        },
    )
}
