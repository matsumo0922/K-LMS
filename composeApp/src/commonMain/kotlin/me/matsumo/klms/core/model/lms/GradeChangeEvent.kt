package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GradeChangeEventEntity

@Serializable
data class GradeChangeEvent(
    val id: String,
    val createdAt: String,
    val eventType: String,
    val excusedAfter: Boolean,
    val excusedBefore: Boolean,
    val gradeAfter: String,
    val gradeBefore: String,
    val gradedAnonymously: Boolean,
    val versionNumber: String,
    val requestId: String,
    val links: GradeChangeEventLinks? = null,
)

fun GradeChangeEventEntity.translate(): GradeChangeEvent {
    return GradeChangeEvent(
        id = id,
        createdAt = createdAt,
        eventType = eventType,
        excusedAfter = excusedAfter,
        excusedBefore = excusedBefore,
        gradeAfter = gradeAfter,
        gradeBefore = gradeBefore,
        gradedAnonymously = gradedAnonymously,
        versionNumber = versionNumber,
        requestId = requestId,
        links = links?.translate(),
    )
}
