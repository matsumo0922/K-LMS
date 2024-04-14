package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintTemplateEntity

@Serializable
data class BlueprintTemplate(
    val id: Int,
    val courseId: Int,
    val lastExportCompletedAt: Instant,
    val associatedCourseCount: Int,
    val latestMigration: String?,
)

fun BlueprintTemplateEntity.translate(): BlueprintTemplate {
    return BlueprintTemplate(
        id = id,
        courseId = courseId,
        lastExportCompletedAt = Instant.parse(lastExportCompletedAt),
        associatedCourseCount = associatedCourseCount,
        latestMigration = latestMigration,
    )
}
