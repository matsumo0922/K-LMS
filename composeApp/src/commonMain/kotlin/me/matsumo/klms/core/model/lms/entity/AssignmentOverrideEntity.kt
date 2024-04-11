package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents an assignment override, which customizes the assignment for certain students, groups, or sections
@Serializable
data class AssignmentOverrideEntity(
    // the ID of the assignment override
    @SerialName("id") val id: Int,
    // the ID of the assignment the override applies to
    @SerialName("assignment_id") val assignmentId: Int?,
    // the ID of the quiz the override applies to
    @SerialName("quiz_id") val quizId: Int?,
    // the ID of the module the override applies to
    @SerialName("context_module_id") val contextModuleId: Int?,
    // the ID of the discussion the override applies to
    @SerialName("discussion_topic_id") val discussionTopicId: Int?,
    // the ID of the page the override applies to
    @SerialName("wiki_page_id") val wikiPageId: Int?,
    // the ID of the file the override applies to
    @SerialName("attachment_id") val attachmentId: Int?,
    // the IDs of the override's target students
    @SerialName("student_ids") val studentIds: List<Int>?,
    // the ID of the override's target group
    @SerialName("group_id") val groupId: Int?,
    // the ID of the overrides's target section
    @SerialName("course_section_id") val courseSectionId: Int?,
    // the title of the override
    @SerialName("title") val title: String,
    // the overridden due at
    @SerialName("due_at") val dueAt: String?,
    // the overridden all day flag
    @SerialName("all_day") val allDay: Boolean?,
    // the overridden all day date
    @SerialName("all_day_date") val allDayDate: String?,
    // the overridden unlock at
    @SerialName("unlock_at") val unlockAt: String?,
    // the overridden lock at, if any
    @SerialName("lock_at") val lockAt: String?
)
