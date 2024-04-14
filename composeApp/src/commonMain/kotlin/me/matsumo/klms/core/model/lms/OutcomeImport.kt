package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeImportEntity

@Serializable
data class OutcomeImport(
    val id: Int,
    val learningOutcomeGroupId: Int?,
    val createdAt: Instant,
    val endedAt: Instant?,
    val updatedAt: Instant,
    val workflowState: String,
    val data: OutcomeImportData?,
    val progress: Int,
    val user: LmsUser?,
    val processingErrors: List<List<Map<Int, String>>>,
)

fun OutcomeImportEntity.translate(): OutcomeImport {
    return OutcomeImport(
        id = id,
        learningOutcomeGroupId = learningOutcomeGroupId,
        createdAt = Instant.parse(createdAt),
        endedAt = endedAt?.let { Instant.parse(it) },
        updatedAt = Instant.parse(updatedAt),
        workflowState = workflowState,
        data = data?.translate(),
        progress = progress,
        user = user?.translate(),
        processingErrors = processingErrors,
    )
}
