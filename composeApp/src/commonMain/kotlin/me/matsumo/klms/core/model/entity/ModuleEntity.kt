package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleEntity(
    // the unique identifier for the module
    @SerialName("id")
    val id: Int,

    // the state of the module
    @SerialName("workflow_state")
    val workflowState: String,

    // the position of this module in the course
    @SerialName("position")
    val position: Int,

    // the name of this module
    @SerialName("name")
    val name: String,

    // (Optional) the date this module will unlock
    @SerialName("unlock_at")
    val unlockAt: String? = null,

    // Whether module items must be unlocked in order
    @SerialName("require_sequential_progress")
    val requireSequentialProgress: Boolean,

    // IDs of Modules that must be completed ...
    @SerialName("prerequisite_module_ids")
    val prerequisiteModuleIds: List<Int>,

    // The number of items in the module
    @SerialName("items_count")
    val itemsCount: Int,

    // The API URL to retrive this module's items
    @SerialName("items_url")
    val itemsUrl: String,

    // The contents of this module ...
    @SerialName("items")
    val items: List<ModuleItemEntity>? = null,

    // The state of this Module for the calling user ...
    @SerialName("state")
    val state: String? = null,

    // the date the calling user completed the module ...
    @SerialName("completed_at")
    val completedAt: String? = null,

    // if the student's final grade ...
    @SerialName("publish_final_grade")
    val publishFinalGrade: Boolean? = null,

    // (Optional) Whether this module is published  ...
    @SerialName("published")
    val published: Boolean? = null

)

// You'll need a 'ModuleItem' data class to represent the items
