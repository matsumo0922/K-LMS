package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
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
    val createdAt: Instant,
    val updatedAt: Instant,
    val message: String? = null,
    val results: LmsResult? = null,
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
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        message = message,
        results = results?.translate(),
        url = url,
    )
}
