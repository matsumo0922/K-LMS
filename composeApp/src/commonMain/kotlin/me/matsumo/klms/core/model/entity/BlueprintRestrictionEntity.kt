package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents a set of restrictions on editing for copied objects in associated courses.
@Serializable
data class BlueprintRestrictionEntity(
    // Restriction on main content (e.g. title, description).
    @SerialName("content") val content: Boolean,
    // Restriction on points possible for assignments and graded learning objects
    @SerialName("points") val points: Boolean,
    // Restriction on due dates for assignments and graded learning objects
    @SerialName("due_dates") val dueDates: Boolean,
    // Restriction on availability dates for an object
    @SerialName("availability_dates") val availabilityDates: Boolean
)
