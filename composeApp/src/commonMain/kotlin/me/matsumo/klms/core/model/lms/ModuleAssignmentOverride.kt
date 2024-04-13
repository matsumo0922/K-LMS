package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ModuleAssignmentOverrideEntity

@Serializable
data class ModuleAssignmentOverride(
    val id: Int,
    val contextModuleId: Int,
    val title: String,
    val students: List<String>? = null,
    val courseSection: CourseSection? = null,
)

fun ModuleAssignmentOverrideEntity.translate(): ModuleAssignmentOverride {
    return ModuleAssignmentOverride(
        id = id,
        contextModuleId = contextModuleId,
        title = title,
        students = students,
        courseSection = courseSection?.translate(),
    )
}
