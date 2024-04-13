package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ProgressEntity

@Serializable
data class LmsProgress(
    val id: Int,
    val contextId: Int,
    val contextType: String,
    val userId: Int,
    val tag: String,
    val completion: Int,
    val workflowState: String,
    val createdAt: String,
    val updatedAt: String,
    val message: String? = null,
    val results: Result? = null,
    val url: String,
)

fun ProgressEntity.translate(): LmsProgress {
    return LmsProgress(
        id = id,
        contextId = contextId,
        contextType = contextType,
        userId = userId,
        tag = tag,
        completion = completion,
        workflowState = workflowState,
        createdAt = createdAt,
        updatedAt = updatedAt,
        message = message,
        results = results?.translate(),
        url = url,
    )
}
