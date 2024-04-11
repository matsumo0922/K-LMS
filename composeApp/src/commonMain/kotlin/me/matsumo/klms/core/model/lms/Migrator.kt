package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Migrator(
        val type: String,

        val requiresFileUpload: Boolean,

        val name: String,

        val requiredSettings: List<String>
)

fun MigratorEntity.translate(): Migrator {
    return Migrator(
        type = type,
        requiresFileUpload = requiresFileUpload,
        name = name
    )
}
