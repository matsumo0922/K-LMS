package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.MigratorEntity

@Serializable
data class Migrator(
    val type: String,
    val requiresFileUpload: Boolean,
    val name: String,
    val requiredSettings: List<String>,
)

fun MigratorEntity.translate(): Migrator {
    return Migrator(
        type = type,
        requiresFileUpload = requiresFileUpload,
        name = name,
        requiredSettings = requiredSettings,
    )
}
