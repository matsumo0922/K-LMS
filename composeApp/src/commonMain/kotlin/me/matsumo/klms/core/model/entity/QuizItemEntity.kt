package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizItemEntity(
    // The ID of the quiz item
    @SerialName("id")
    val id: String,

    // The position of the item within the quiz.
    @SerialName("position")
    val position: Int,

    // The number of points available
    @SerialName("points_possible")
    val pointsPossible: Double,

    // The type of item.
    @SerialName("entry_type")
    val entryType: String,

    // Whether the current user can edit ...
    @SerialName("entry_editable")
    val entryEditable: Boolean,

    //  ID of the stimulus ...
    @SerialName("stimulus_quiz_entry_id")
    val stimulusQuizEntryId: String?,

    // Status of the item.
    @SerialName("status")
    val status: String,

    // The specific data associated with the quiz item.
    @SerialName("entry")
    val entry: EntryEntity?
)
