package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Represents a blueprint template which is a set of course materials that can be used in other courses.
@Serializable
data class BlueprintTemplateEntity(
    // The ID of the template.
    @SerialName("id") val id: Int,
    // The ID of the Course the template belongs to.
    @SerialName("course_id") val courseId: Int,
    // Time when the last export was completed
    @SerialName("last_export_completed_at") val lastExportCompletedAt: String,
    // Number of associated courses for the template
    @SerialName("associated_course_count") val associatedCourseCount: Int,
    // Details of the latest migration
    @SerialName("latest_migration") val latestMigration: String?
)
