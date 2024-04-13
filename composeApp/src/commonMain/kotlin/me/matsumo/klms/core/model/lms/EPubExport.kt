package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EPubExportEntity

@Serializable
data class EPubExport(
    val id: Int,
    val createdAt: String,
    val attachment: Attachment? = null,
    val progressUrl: String,
    val userId: Int,
    val workflowState: String,
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
        attachment = attachment?.url?.let {
            EPubExport.Attachment(
                url = it,
            )
        },
        progressUrl = progressUrl,
        userId = userId,
        workflowState = workflowState,
    )
}
