package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentShareEntity

@Serializable
data class ContentShare(
    val id: Int,
    val name: String,
    val contentType: String,
    val createdAt: Instant,
    val updatedAt: Instant,
    val userId: Int,
    val sender: LmsUser? = null,
    val receivers: List<LmsUser> = emptyList(),
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
        createdAt = Instant.parse(createdAt),
        updatedAt = Instant.parse(updatedAt),
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
