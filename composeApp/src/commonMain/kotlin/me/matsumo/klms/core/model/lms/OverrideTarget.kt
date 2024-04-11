package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverrideTarget(
        val id: Int,

        val name: String
)

fun OverrideTargetEntity.translate(): OverrideTarget {
    return OverrideTarget(
        id = id
    )
}
