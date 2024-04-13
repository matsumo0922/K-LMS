package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.LicenseEntity

@Serializable
data class LmsLicense(
    val id: String,
    val name: String,
    val url: String,
)

fun LicenseEntity.translate(): LmsLicense {
    return LmsLicense(
        id = id,
        name = name,
        url = url,
    )
}
