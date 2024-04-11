package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeImport(
        val id: Int,

        val learningOutcomeGroupId: Int?,

        val createdAt: String,

        val endedAt: String?,

        val updatedAt: String,

        val workflowState: String,

        val data: OutcomeImportDataEntity?,

        val progress: Int, 
        val user: UserEntity?, 
        val processingErrors: List<List<Map<Int, String>>> )



fun OutcomeImportEntity.translate(): OutcomeImport {
    return OutcomeImport(
        id = id,
        learningOutcomeGroupId = learningOutcomeGroupId,
        createdAt = createdAt,
        endedAt = endedAt,
        updatedAt = updatedAt,
        workflowState = workflowState,
        data = data,
        progress = progress,
        user = user,
        processingErrors = processingErrors
    )
}
