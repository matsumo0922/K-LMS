package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssignmentGroupEntity(
    // the id of the Assignment Group
    @SerialName("id") val id: Int,
    // the name of the Assignment Group
    @SerialName("name") val name: String,
    // the position of the Assignment Group
    @SerialName("position") val position: Int,
    // the weight of the Assignment Group
    @SerialName("group_weight") val groupWeight: Int,
    // the sis source id of the Assignment Group
    @SerialName("sis_source_id") val sisSourceId: String,
    // the integration data of the Assignment Group
    @SerialName("integration_data") val integrationData: Map<String, String>,
    // the assignments in this Assignment Group
    @SerialName("assignments") val assignments: List<String>,
    // the grading rules that this Assignment Group has
    @SerialName("rules") val rules: GradingRulesEntity?
)
