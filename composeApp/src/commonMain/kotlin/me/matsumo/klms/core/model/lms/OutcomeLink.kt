package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.OutcomeLinkEntity

@Serializable
data class OutcomeLink(
    val url: String,
    val contextId: Int,
    val contextType: String,
    val outcomeGroup: OutcomeGroup?,
    val outcome: Outcome?,
    val assessed: Boolean,
    val canUnlink: Boolean? = null,
)

fun OutcomeLinkEntity.translate(): OutcomeLink {
    return OutcomeLink(
        url = url,
        contextId = contextId,
        contextType = contextType,
        outcomeGroup = outcomeGroup?.translate(),
        outcome = outcome?.translate(),
        assessed = assessed,
    )
}
