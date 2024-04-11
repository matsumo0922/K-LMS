package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Module(
        val id: Int,

        val workflowState: String,

        val position: Int,

        val name: String,

        val unlockAt: String? = null,

        val requireSequentialProgress: Boolean,

        val prerequisiteModuleIds: List<Int>,

        val itemsCount: Int,

        val itemsUrl: String,

        val items: List<ModuleItemEntity>? = null,

        val state: String? = null,

        val completedAt: String? = null,

        val publishFinalGrade: Boolean? = null,

        val published: Boolean? = null

)


fun ModuleEntity.translate(): Module {
    return Module(
        id = id,
        workflowState = workflowState,
        position = position,
        name = name,
        unlockAt = unlockAt,
        requireSequentialProgress = requireSequentialProgress,
        prerequisiteModuleIds = prerequisiteModuleIds,
        itemsCount = itemsCount,
        itemsUrl = itemsUrl,
        items = items,
        state = state,
        completedAt = completedAt,
        publishFinalGrade = publishFinalGrade
    )
}
