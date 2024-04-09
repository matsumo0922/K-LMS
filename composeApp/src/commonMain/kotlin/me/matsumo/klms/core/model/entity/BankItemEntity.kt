package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BankItemEntity(
    // The title of the bank
    @SerialName("title")
    val title: String,

    // Whether the bank is archived
    @SerialName("archived")
    val archived: Boolean,

    // The number of items in the bank, including stimuli
    @SerialName("entry_count")
    val entryCount: Int,

    // The number of items in the bank, excluding stimuli
    @SerialName("item_entry_count")
    val itemEntryCount: Int
) : EntryEntity
