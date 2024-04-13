package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentShareEntity

@Serializable
data class ContentShare(
    val id: Int,
    val name: String,
    val contentType: String,
    val createdAt: String,
    val updatedAt: String,
    val userId: Int,
    val sender: User? = null,
    val receivers: List<User> = emptyList(),
    val sourceCourse: SourceCourse,
    val readState: String,
    val contentExport: ContentExport,
) {
    @Serializable
    data class SourceCourse(
        val id: Int,
        val name: String,
    )

    @Serializable
    data class ContentExport(
        val id: Int,
    )
}

fun ContentShareEntity.translate(): ContentShare {
    return ContentShare(
        id = id,
        name = name,
        contentType = contentType,
        createdAt = createdAt,
        updatedAt = updatedAt,
        userId = userId,
        sender = sender?.translate(),
        receivers = receivers.map { it.translate() },
        sourceCourse = ContentShare.SourceCourse(
            id = sourceCourse.id,
            name = sourceCourse.name,
        ),
        readState = readState,
        contentExport = ContentShare.ContentExport(
            id = contentExport.id,
        ),
    )
}
