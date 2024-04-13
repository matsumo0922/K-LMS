package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultViewSettingsEntity(
    // Whether to restrict the student result view
    @SerialName("result_view_restricted")
    val resultViewRestricted: Boolean,
    // Whether to show points awarded per question.
    @SerialName("display_points_awarded")
    val displayPointsAwarded: Boolean,
    // Whether to show points possible per question.
    @SerialName("display_points_possible")
    val displayPointsPossible: Boolean,
    // Whether to show questions in the result view.
    @SerialName("display_items")
    val displayItems: Boolean,
    // Whether to show student's responses.
    @SerialName("display_item_response")
    val displayItemResponse: Boolean,
    // Whether to indicate correctness of student's responses.
    @SerialName("display_item_response_correctness")
    val displayItemResponseCorrectness: Boolean,
    // Whether to show the correct answer for each question.
    @SerialName("display_item_correct_answer")
    val displayItemCorrectAnswer: Boolean,
    // Whether to show feedback for each item.
    @SerialName("display_item_feedback")
    val displayItemFeedback: Boolean,
)
