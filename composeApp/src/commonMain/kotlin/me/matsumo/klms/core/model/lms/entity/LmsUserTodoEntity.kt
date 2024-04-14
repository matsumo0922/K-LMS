package me.matsumo.klms.core.model.lms.entity


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LmsUserTodoEntity(
    @SerialName("context_type")
    val contextType: String,
    @SerialName("course_id")
    val courseId: Int,
    @SerialName("group_id")
    val groupId: Int,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("ignore")
    val ignore: String,
    @SerialName("ignore_permanently")
    val ignorePermanently: String,
    @SerialName("needs_grading_count")
    val needsGradingCount: Int,
    @SerialName("assignment")
    val assignment: AssignmentEntity,
)
