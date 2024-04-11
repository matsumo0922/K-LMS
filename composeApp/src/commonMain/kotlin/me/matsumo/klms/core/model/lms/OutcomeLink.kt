package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeLink(
        val url: String,

        val contextId: Int,

    val contextType: String,

        val outcomeGroup: OutcomeGroupEntity?,

        val outcome: OutcomeEntity?,

        val assessed: Boolean,

        val canUnlink: Boolean? = null
)

fun OutcomeLinkEntity.translate(): OutcomeLink {
    return OutcomeLink(
        url = url,
        contextId = contextId,
        contextType = contextType,
        outcomeGroup = outcomeGroup,
        outcome = outcome,
        assessed = assessed
    )
}
