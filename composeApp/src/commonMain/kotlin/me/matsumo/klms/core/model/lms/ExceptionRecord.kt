package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ExceptionRecordEntity

@Serializable
data class ExceptionRecord(
        val courseId: Int,
        val conflictingChanges: List<String>
)

fun ExceptionRecordEntity.translate(): ExceptionRecord {
    return ExceptionRecord(
        courseId = courseId,
        conflictingChanges = conflictingChanges
    )
}
