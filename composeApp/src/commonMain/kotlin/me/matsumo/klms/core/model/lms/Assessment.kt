package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssessmentEntity

@Serializable
data class Assessment(
    val id: String,
    val key: String,
    val title: String,
)

fun AssessmentEntity.translate(): Assessment {
    return Assessment(
        id = id,
        key = key,
        title = title,
    )
}
