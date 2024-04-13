package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BankEntryItemEntity(
    // The type of item.
    @SerialName("entry_type")
    val entryType: String,
    // Whether the banked item is archived
    @SerialName("archived")
    val archived: Boolean,
    // the item (either a QuestionItem or StimulusItem, depending on entry_type)
    @SerialName("entry")
    val entry: me.matsumo.klms.core.model.lms.entity.EntryEntity? = null,
)
