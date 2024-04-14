package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CollaborationEntity

@Serializable
data class Collaboration(
    val id: Int,
    val collaborationType: String,
    val documentId: String,
    val userId: Int,
    val contextId: Int,
    val contextType: String,
    val url: String? = null,
    val createdAt: Instant,
    val updatedAt: Instant,
    val description: String? = null,
    val title: String? = null,
    val type: String,
    val updateUrl: String? = null,
    val userName: String,
)

fun CollaborationEntity.translate(): Collaboration {
    return Collaboration(
        id = id,
        collaborationType = collaborationType,
        documentId = documentId,
        userId = userId,
        contextId = contextId,
        contextType = contextType,
        url = url,
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
        description = description,
        title = title,
        type = type,
        updateUrl = updateUrl,
        userName = userName,
    )
}
