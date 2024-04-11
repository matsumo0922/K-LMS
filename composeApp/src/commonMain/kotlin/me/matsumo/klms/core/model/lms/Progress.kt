package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Progress(
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

        val results: ResultEntity? = null, 
        val url: String,
)

fun ProgressEntity.translate(): Progress {
    return Progress(
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
        results = results,
        url = url
    )
}
