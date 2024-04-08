package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeRollupLinks(
    // Optional ID of the course
    @SerialName("course")
    val course: Int? = null,

    // Optional ID of the user
    @SerialName("user")
    val user: Int? = null,

    // Optional ID of the section
    @SerialName("section")
    val section: Int?  = null
)
