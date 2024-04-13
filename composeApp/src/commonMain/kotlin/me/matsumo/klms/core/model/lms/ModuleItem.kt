package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ModuleItemEntity

@Serializable
data class ModuleItem(
    val id: Int,
    val moduleId: Int,
    val position: Int,
    val title: String,
    val indent: Int,
    val type: String,
    val contentId: Int?,
    val htmlUrl: String,
    val url: String? = null,
    val pageUrl: String? = null,
    val externalUrl: String? = null,
    val newTab: Boolean? = null,
    val completionRequirement: CompletionRequirement,
    val contentDetails: ContentDetails? = null,
    val published: Boolean? = null,
)

fun ModuleItemEntity.translate(): ModuleItem {
    return ModuleItem(
        id = id,
        moduleId = moduleId,
        position = position,
        title = title,
        indent = indent,
        type = type,
        contentId = contentId,
        htmlUrl = htmlUrl,
        url = url,
        pageUrl = pageUrl,
        externalUrl = externalUrl,
        newTab = newTab,
        completionRequirement = completionRequirement.translate(),
        contentDetails = contentDetails?.translate(),
    )
}
