package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ChangeRecordEntity

@Serializable
data class ChangeRecord(
    val assetId: Int,
    val assetType: String,
    val assetName: String,
    val changeType: String,
    val htmlUrl: String,
    val locked: Boolean,
    val exceptions: List<ExceptionRecord>,
)

fun ChangeRecordEntity.translate(): ChangeRecord {
    return ChangeRecord(
        assetId = assetId,
        assetType = assetType,
        assetName = assetName,
        changeType = changeType,
        htmlUrl = htmlUrl,
        locked = locked,
        exceptions = exceptions.map { it.translate() },
    )
}
