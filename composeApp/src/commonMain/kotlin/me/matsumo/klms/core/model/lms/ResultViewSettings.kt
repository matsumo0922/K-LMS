package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultViewSettings(
        val resultViewRestricted: Boolean,

        val displayPointsAwarded: Boolean,

        val displayPointsPossible: Boolean,

        val displayItems: Boolean,

        val displayItemResponse: Boolean,

        val displayItemResponseCorrectness: Boolean,

        val displayItemCorrectAnswer: Boolean,

        val displayItemFeedback: Boolean
)

fun ResultViewSettingsEntity.translate(): ResultViewSettings {
    return ResultViewSettings(
        resultViewRestricted = resultViewRestricted,
        displayPointsAwarded = displayPointsAwarded,
        displayPointsPossible = displayPointsPossible,
        displayItems = displayItems,
        displayItemResponse = displayItemResponse,
        displayItemResponseCorrectness = displayItemResponseCorrectness,
        displayItemCorrectAnswer = displayItemCorrectAnswer
    )
}
