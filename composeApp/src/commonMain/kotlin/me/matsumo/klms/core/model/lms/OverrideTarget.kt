package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OverrideTargetEntity

@Serializable
data class OverrideTarget(
    val id: Int,
    val name: String,
)

fun OverrideTargetEntity.translate(): OverrideTarget {
    return OverrideTarget(
        id = id,
        name = name,
    )
}
