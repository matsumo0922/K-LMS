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
    val dueAt: String?,
    val allDay: Boolean?,
    val allDayDate: Instant?,
    val unlockAt: String?,
    val lockAt: String?,
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
        dueAt = dueAt,
        allDay = allDay,
        allDayDate = allDayDate?.let { Instant.parse(it) },
        unlockAt = unlockAt,
        lockAt = lockAt,
    )
}
