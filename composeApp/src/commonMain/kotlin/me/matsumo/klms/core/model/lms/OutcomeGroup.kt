package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeGroup(
        val id: Int,

        val url: String,

        val parentOutcomeGroup: OutcomeGroupEntity?,

        val contextId: Int?,

    val contextType: String,

        val title: String,

        val description: String?,

        val vendorGuid: String?,

        val subgroupsUrl: String,

        val outcomesUrl: String,

        val importUrl: String?,

        val canEdit: Boolean
)

fun OutcomeGroupEntity.translate(): OutcomeGroup {
    return OutcomeGroup(
        id = id,
        url = url,
        parentOutcomeGroup = parentOutcomeGroup,
        contextId = contextId,
        contextType = contextType,
        title = title,
        description = description,
        vendorGuid = vendorGuid,
        subgroupsUrl = subgroupsUrl,
        outcomesUrl = outcomesUrl,
        importUrl = importUrl
    )
}
