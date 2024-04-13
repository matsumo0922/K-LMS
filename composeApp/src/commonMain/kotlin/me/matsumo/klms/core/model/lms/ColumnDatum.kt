package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ColumnDatumEntity

@Serializable
data class ColumnDatum(
    val content: String,
    val userId: Int,
)

fun ColumnDatumEntity.translate(): ColumnDatum {
    return ColumnDatum(
        content = content,
        userId = userId,
    )
}
