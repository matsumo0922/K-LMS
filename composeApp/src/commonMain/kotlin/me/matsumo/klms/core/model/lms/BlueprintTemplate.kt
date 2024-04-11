package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintTemplateEntity

@Serializable
data class BlueprintTemplate(
        val id: Int,
        val courseId: Int,
        val lastExportCompletedAt: String,
        val associatedCourseCount: Int,
        val latestMigration: String?
)

fun BlueprintTemplateEntity.translate(): BlueprintTemplate {
    return BlueprintTemplate(
        id = id,
        courseId = courseId,
        lastExportCompletedAt = lastExportCompletedAt,
        associatedCourseCount = associatedCourseCount,
        latestMigration = latestMigration
    )
}
