package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.RubricCriteriaEntity

@Serializable
data class RubricCriteria(
        val points: Int,
        val id: String,
        val learningOutcomeId: String?,
        val vendorGuid: String?,
        val description: String,
        val longDescription: String,
        val criterionUseRange: Boolean,
        val ratings: List<RubricRatingEntity>?,
        val ignoreForScoring: Boolean
)

fun RubricCriteriaEntity.translate(): RubricCriteria {
    return RubricCriteria(
        points = points,
        id = id,
        learningOutcomeId = learningOutcomeId,
        vendorGuid = vendorGuid,
        description = description,
        longDescription = longDescription,
        criterionUseRange = criterionUseRange,
        ratings = ratings
    )
}
