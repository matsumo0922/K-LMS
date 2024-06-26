package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.UsageRightsEntity

@Serializable
data class UsageRights(
    val legalCopyright: String,
    val useJustification: String,
    val license: String,
    val licenseName: String,
    val message: String,
    val fileIds: List<Int>,
)

fun UsageRightsEntity.translate(): UsageRights {
    return UsageRights(
        legalCopyright = legalCopyright,
        useJustification = useJustification,
        license = license,
        licenseName = licenseName,
        message = message,
        fileIds = fileIds,
    )
}
