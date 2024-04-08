package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayEntity(
    // the date represented by this entry
    @SerialName("date")
    val date: String,

    // an array of the graders who were responsible for the submissions...
    @SerialName("graders")
    val graders: List<GraderEntity>
)

// You already have the 'GraderEntity' definition from the previous example
