package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ContentExportEntity

@Serializable
data class ContentExport(
    val id: Int,
    val createdAt: String,
    val exportType: String,
    val attachment: Attachment,
    val progressUrl: String,
    val userId: Int,
    val workflowState: String,
) {
    @Serializable
    data class Attachment(
        val url: String,
    )
}

fun ContentExportEntity.translate(): ContentExport {
    return ContentExport(
        id = id,
        createdAt = createdAt,
        exportType = exportType,
        attachment = ContentExport.Attachment(
            url = attachment.url,
        ),
        progressUrl = progressUrl,
        userId = userId,
        workflowState = workflowState,
    )
}
