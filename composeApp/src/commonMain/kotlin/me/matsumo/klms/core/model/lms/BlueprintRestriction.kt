package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintRestrictionEntity

@Serializable
data class BlueprintRestriction(
    val content: Boolean,
    val points: Boolean,
    val dueDates: Boolean,
    val availabilityDates: Boolean,
)

fun BlueprintRestrictionEntity.translate(): BlueprintRestriction {
    return BlueprintRestriction(
        content = content,
        points = points,
        dueDates = dueDates,
        availabilityDates = availabilityDates,
    )
}
