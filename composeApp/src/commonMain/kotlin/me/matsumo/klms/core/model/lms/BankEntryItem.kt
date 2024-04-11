package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BankEntryItemEntity
import me.matsumo.klms.core.model.lms.entity.EntryEntity

@Serializable
data class BankEntryItem(
        val entryType: String,

        val archived: Boolean,

        val entry: EntryEntity? = null
)

fun BankEntryItemEntity.translate(): BankEntryItem {
    return BankEntryItem(
        entryType = entryType,
        archived = archived,
        entry = entry?.translate()
    )
}
