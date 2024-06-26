package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ModuleEntity

@Serializable
data class LmsModule(
    val id: Int,
    val workflowState: String,
    val position: Int,
    val name: String,
    val unlockAt: Instant? = null,
    val requireSequentialProgress: Boolean,
    val prerequisiteModuleIds: List<Int>,
    val itemsCount: Int,
    val itemsUrl: String,
    val items: List<ModuleItem> = emptyList(),
    val state: String? = null,
    val completedAt: Instant? = null,
    val publishFinalGrade: Boolean? = null,
    val published: Boolean? = null,
)

fun ModuleEntity.translate(): LmsModule {
    return LmsModule(
        id = id,
        workflowState = workflowState,
        position = position,
        name = name,
        unlockAt = unlockAt?.let { Instant.parse(it) },
        requireSequentialProgress = requireSequentialProgress,
        prerequisiteModuleIds = prerequisiteModuleIds,
        itemsCount = itemsCount,
        itemsUrl = itemsUrl,
        items = items?.map { it.translate() } ?: emptyList(),
        state = state,
        completedAt = completedAt?.let { Instant.parse(it) },
        publishFinalGrade = publishFinalGrade,
    )
}
