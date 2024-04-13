package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompletionRequirementEntity(
    // one of 'must_view', 'must_submit' ...
    @SerialName("type")
    val type: String,
    // minimum score required to complete ...
    @SerialName("min_score")
    val minScore: Int? = null,
    // whether the calling user has met this requirement...
    @SerialName("completed")
    val completed: Boolean? = null,
)
