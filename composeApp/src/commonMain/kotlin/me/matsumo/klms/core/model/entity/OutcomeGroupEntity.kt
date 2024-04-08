package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeGroupEntity(
    // The ID of the outcome group
    @SerialName("id")
    val id: Int,

    // The URL for fetching/updating the outcome group
    @SerialName("url")
    val url: String,

    // The parent group
    @SerialName("parent_outcome_group")
    val parentOutcomeGroup: OutcomeGroupEntity?,

    // The context owning the outcome group
    @SerialName("context_id")
    val contextId: Int?,

    @SerialName("context_type")
    val contextType: String,

    // Title of the outcome group
    @SerialName("title")
    val title: String,

    // Description
    @SerialName("description")
    val description: String?,

    // Custom GUID
    @SerialName("vendor_guid")
    val vendorGuid: String?,

    // The URL for listing/creating subgroups
    @SerialName("subgroups_url")
    val subgroupsUrl: String,

    // The URL for listing/creating outcomes
    @SerialName("outcomes_url")
    val outcomesUrl: String,

    // The URL for importing
    @SerialName("import_url")
    val importUrl: String?,

    // Whether the current user can update the outcome group
    @SerialName("can_edit")
    val canEdit: Boolean
)
