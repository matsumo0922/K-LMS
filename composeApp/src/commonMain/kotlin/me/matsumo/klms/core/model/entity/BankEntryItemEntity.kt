package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class BankEntryItemEntity(
    // The type of item.
    @SerialName("entry_type")
    val entryType: String,

    // Whether the banked item is archived
    @SerialName("archived")
    val archived: Boolean,

    // The item.
    @SerialName("entry")
    val entry: EntryItem? = null
)
