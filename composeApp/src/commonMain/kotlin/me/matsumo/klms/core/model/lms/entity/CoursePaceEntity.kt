package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoursePaceEntity(
    // the ID of the course pace
    @SerialName("id")
    val id: Int,
    // the ID of the course
    @SerialName("course_id")
    val courseId: Int,
    // the ID of the user for this course pace
    @SerialName("user_id")
    val userId: Int,
    // the state of the course pace
    @SerialName("workflow_state")
    val workflowState: String,
    // boolean value depending on exclude weekends setting
    @SerialName("exclude_weekends")
    val excludeWeekends: Boolean,
    // set if the end date is set from course
    @SerialName("hard_end_dates")
    val hardEndDates: Boolean,
    // date when course pace is created
    @SerialName("created_at")
    val createdAt: String,
    // course end date
    @SerialName("end_date")
    val endDate: String,
    // date when course pace is updated
    @SerialName("updated_at")
    val updatedAt: String,
    // date when course pace is published
    @SerialName("published_at")
    val publishedAt: String,
    // the root account ID for this course pace
    @SerialName("root_account_id")
    val rootAccountId: Int,
    // course start date
    @SerialName("start_date")
    val startDate: String,
    // list of modules and items for this course pace
    @SerialName("modules")
    val modules: List<me.matsumo.klms.core.model.lms.entity.ModuleEntity>? = null,
    // progress of pace publishing
    @SerialName("progress")
    val progress: me.matsumo.klms.core.model.lms.entity.ProgressEntity? = null,
)

// Remember, you'll likely need 'Module' and 'Progress' data classes defined previously
