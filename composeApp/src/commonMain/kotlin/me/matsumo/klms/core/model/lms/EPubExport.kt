package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPubExport(
        val id: Int,

        val createdAt: String,

        val attachment: Attachment? = null, 
        val progressUrl: String,

        val userId: Int,

        val workflowState: String
) {

    @Serializable
    data class Attachment(
        val url: Int,
    )
}


fun EPubExportEntity.translate(): EPubExport {
    return EPubExport(
        id = id,
        createdAt = createdAt,
        attachment = attachment,
        progressUrl = progressUrl,
        userId = userId,
        url = url
    )
}
