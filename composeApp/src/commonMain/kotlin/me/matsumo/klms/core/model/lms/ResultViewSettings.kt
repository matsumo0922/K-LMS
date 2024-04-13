package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ResultViewSettingsEntity

@Serializable
data class ResultViewSettings(
    val resultViewRestricted: Boolean,
    val displayPointsAwarded: Boolean,
    val displayPointsPossible: Boolean,
    val displayItems: Boolean,
    val displayItemResponse: Boolean,
    val displayItemResponseCorrectness: Boolean,
    val displayItemCorrectAnswer: Boolean,
    val displayItemFeedback: Boolean,
)

fun ResultViewSettingsEntity.translate(): ResultViewSettings {
    return ResultViewSettings(
        resultViewRestricted = resultViewRestricted,
        displayPointsAwarded = displayPointsAwarded,
        displayPointsPossible = displayPointsPossible,
        displayItems = displayItems,
        displayItemResponse = displayItemResponse,
        displayItemResponseCorrectness = displayItemResponseCorrectness,
        displayItemCorrectAnswer = displayItemCorrectAnswer,
        displayItemFeedback = displayItemFeedback,
    )
}
