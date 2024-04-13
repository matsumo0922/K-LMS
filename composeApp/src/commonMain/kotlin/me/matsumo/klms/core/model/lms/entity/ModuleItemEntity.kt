package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable@Serializable
data class ModuleItemEntity(
    // The unique identifier for the module item
    @SerialName("id")
    val id: Int,
    // The ID of the Module this item appears in
    @SerialName("module_id")
    val moduleId: Int,
    // The position of this item in the module (1-based)
    @SerialName("position")
    val position: Int,
    // The title of this item
    @SerialName("title")
    val title: String,
    // 0-based indent level ...
    @SerialName("indent")
    val indent: Int,
    // The type of object referred to ...
    @SerialName("type")
    val type: String,
    // The ID of the object referred to ...
    @SerialName("content_id")
    val contentId: Int?,
    // Link to the item in Canvas
    @SerialName("html_url")
    val htmlUrl: String,
    // (Optional) Link to the Canvas API object ...
    @SerialName("url")
    val url: String? = null,
    // (only for 'Page' type) Unique locator for the ...
    @SerialName("page_url")
    val pageUrl: String? = null,
    // (only for 'ExternalUrl' and 'ExternalTool' ...
    @SerialName("external_url")
    val externalUrl: String? = null,
    // (only for 'ExternalTool' type) Whether the ...
    @SerialName("new_tab")
    val newTab: Boolean? = null,
    // Completion requirement...
    @SerialName("completion_requirement")
    val completionRequirement: me.matsumo.klms.core.model.lms.entity.CompletionRequirementEntity,
    // (Present only if requested through include[]=content_details ...
    @SerialName("content_details")
    val contentDetails: me.matsumo.klms.core.model.lms.entity.ContentDetailsEntity? = null,
    // (Optional) Whether this module item is published ...
    @SerialName("published")
    val published: Boolean? = null,
)

// You'll likely already have a 'ContentDetails' data class from a previous example
