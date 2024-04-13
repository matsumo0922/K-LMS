package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BankItemEntity
import me.matsumo.klms.core.model.lms.entity.EntryEntity

@Serializable
data class BankItem(
    val title: String,
    val archived: Boolean,
    val entryCount: Int,
    val itemEntryCount: Int,
) : EntryEntity

fun BankItemEntity.translate(): BankItem {
    return BankItem(
        title = title,
        archived = archived,
        entryCount = entryCount,
        itemEntryCount = itemEntryCount,
    )
}
