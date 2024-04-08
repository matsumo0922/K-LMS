package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleAssignmentOverrideEntity(
    // the ID of the assignment override
    @SerialName("id")
    val id: Int,

    // the ID of the module the override applies to
    @SerialName("context_module_id")
    val contextModuleId: Int,

    // the title of the override
    @SerialName("title")
    val title: String,

    // an array of the override's target students ...
    @SerialName("students")
    val students: List<String>? = null,

    // the override's target section ...
    @SerialName("course_section")
    val courseSection: CourseSectionEntity? = null
)

// You'll likely need a 'CourseSectionEntity' data class if you don't have one
