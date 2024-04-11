package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.entity.GradingRules
import me.matsumo.klms.core.model.lms.entity.AssignmentGroupEntity
import me.matsumo.klms.core.model.lms.entity.GradingRulesEntity

@Serializable
data class AssignmentGroup(
        val id: Int,
        val name: String,
        val position: Int,
        val groupWeight: Int,
        val sisSourceId: String,
        val integrationData: Map<String, String>,
        val assignments: List<String>,
        val rules: GradingRules?
)

fun AssignmentGroupEntity.translate(): AssignmentGroup {
    return AssignmentGroup(
        id = id,
        name = name,
        position = position,
        groupWeight = groupWeight,
        sisSourceId = sisSourceId,
        integrationData = integrationData,
        assignments = assignments,
        rules = rules?.translate()
    )
}
