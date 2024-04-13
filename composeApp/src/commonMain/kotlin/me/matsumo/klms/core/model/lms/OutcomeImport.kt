package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeImportEntity

@Serializable
data class OutcomeImport(
    val id: Int,
    val learningOutcomeGroupId: Int?,
    val createdAt: String,
    val endedAt: String?,
    val updatedAt: String,
    val workflowState: String,
    val data: OutcomeImportData?,
    val progress: Int,
    val user: User?,
    val processingErrors: List<List<Map<Int, String>>>,
)

fun OutcomeImportEntity.translate(): OutcomeImport {
    return OutcomeImport(
        id = id,
        learningOutcomeGroupId = learningOutcomeGroupId,
        createdAt = createdAt,
        endedAt = endedAt,
        updatedAt = updatedAt,
        workflowState = workflowState,
        data = data?.translate(),
        progress = progress,
        user = user?.translate(),
        processingErrors = processingErrors,
    )
}
