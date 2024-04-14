package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AssignmentOverrideEntity

@Serializable
data class AssignmentOverride(
    val id: Int,
    val assignmentId: Int?,
    val quizId: Int?,
    val contextModuleId: Int?,
    val discussionTopicId: Int?,
    val wikiPageId: Int?,
    val attachmentId: Int?,
    val studentIds: List<Int>?,
    val groupId: Int?,
    val courseSectionId: Int?,
    val title: String,
    val dueAt: Instant?,
    val allDay: Boolean?,
    val allDayDate: Instant?,
    val unlockAt: Instant?,
    val lockAt: Instant?,
)

fun AssignmentOverrideEntity.translate(): AssignmentOverride {
    return AssignmentOverride(
        id = id,
        assignmentId = assignmentId,
        quizId = quizId,
        contextModuleId = contextModuleId,
        discussionTopicId = discussionTopicId,
        wikiPageId = wikiPageId,
        attachmentId = attachmentId,
        studentIds = studentIds,
        groupId = groupId,
        courseSectionId = courseSectionId,
        title = title,
        dueAt = dueAt?.let { Instant.parse(it) },
        allDay = allDay,
        allDayDate = allDayDate?.let { Instant.parse(it) },
        unlockAt = unlockAt?.let { Instant.parse(it) },
        lockAt = lockAt?.let { Instant.parse(it) },
    )
}
