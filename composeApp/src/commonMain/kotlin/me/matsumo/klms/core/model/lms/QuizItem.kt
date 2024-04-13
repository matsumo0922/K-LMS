package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizItemEntity

@Serializable
data class QuizItem(
    val id: String,
    val position: Int,
    val pointsPossible: Double,
    val entryType: String,
    val entryEditable: Boolean,
    val stimulusQuizEntryId: String?,
    val status: String,
    // val entry: EntryEntity?
)

fun QuizItemEntity.translate(): QuizItem {
    return QuizItem(
        id = id,
        position = position,
        pointsPossible = pointsPossible,
        entryType = entryType,
        entryEditable = entryEditable,
        stimulusQuizEntryId = stimulusQuizEntryId,
        status = status,
    )
}
