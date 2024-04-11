package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentExport(
        val id: Int,

        val createdAt: String,

        val exportType: String,

        val attachment: Attachment,

        val progressUrl: String,

        val userId: Int,

        val workflowState: String
) {
    @Serializable
    data class Attachment(
        val url: String
    )
}

fun ContentExportEntity.translate(): ContentExport {
    return ContentExport(
        id = id,
        createdAt = createdAt,
        exportType = exportType,
        attachment = attachment,
        progressUrl = progressUrl,
        userId = userId
    )
}
