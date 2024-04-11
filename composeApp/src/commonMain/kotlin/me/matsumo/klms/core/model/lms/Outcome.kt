package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeEntity

@Serializable
data class Outcome(
        val id: Int,

        val url: String,

        val contextId: Int?,

    val contextType: String,

        val title: String,

        val displayName: String?,

        val description: String?,

        val vendorGuid: String?,

        val pointsPossible: Double?, 
        val masteryPoints: Double?,

        val calculationMethod: String,

        val calculationInt: Int?,

        val ratings: List<RubricRatingEntity>?,

        val canEdit: Boolean,

        val canUnlink: Boolean,

        val assessed: Boolean,

        val hasUpdateableRubrics: Boolean
)

fun OutcomeEntity.translate(): Outcome {
    return Outcome(
        id = id,
        url = url,
        contextId = contextId,
        contextType = contextType,
        title = title,
        displayName = displayName,
        description = description,
        vendorGuid = vendorGuid,
        pointsPossible = pointsPossible,
        masteryPoints = masteryPoints,
        calculationMethod = calculationMethod,
        calculationInt = calculationInt,
        ratings = ratings,
        canEdit = canEdit,
        canUnlink = canUnlink,
        assessed = assessed
    )
}
