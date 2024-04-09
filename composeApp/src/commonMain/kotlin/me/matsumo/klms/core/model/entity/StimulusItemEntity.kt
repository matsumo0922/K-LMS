package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StimulusItemEntity(
    //  Stimulus title
    @SerialName("title")
    val title: String,

    //  Stimulus content (rich content)
    @SerialName("body")
    val body: String,

    // additional instructions ...
    @SerialName("instructions")
    val instructions: String? = null,

    // Optional URL ...
    @SerialName("source_url")
    val sourceUrl: String? = null,

    // Where the stimulus appears ('top' or 'left')
    @SerialName("orientation")
    val orientation: String
) : EntryEntity
