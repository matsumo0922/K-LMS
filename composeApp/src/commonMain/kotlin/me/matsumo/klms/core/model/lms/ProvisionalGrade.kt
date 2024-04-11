package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProvisionalGrade(
        val provisionalGradeId: Int,

        val score: Double, 
        val grade: String,

        val gradeMatchesCurrentSubmission: Boolean,

        val gradedAt: String,

        val final: Boolean,

        val speedgraderUrl: String
)

fun ProvisionalGradeEntity.translate(): ProvisionalGrade {
    return ProvisionalGrade(
        provisionalGradeId = provisionalGradeId,
        score = score,
        grade = grade,
        gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission,
        gradedAt = gradedAt,
        final = final
    )
}
