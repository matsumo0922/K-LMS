package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleAssignmentOverride(
        val id: Int,

        val contextModuleId: Int,

        val title: String,

        val students: List<String>? = null,

        val courseSection: CourseSectionEntity? = null
)


fun ModuleAssignmentOverrideEntity.translate(): ModuleAssignmentOverride {
    return ModuleAssignmentOverride(
        id = id,
        contextModuleId = contextModuleId,
        title = title,
        students = students
    )
}
