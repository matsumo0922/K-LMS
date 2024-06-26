package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ProvisionalGradeEntity

@Serializable
data class ProvisionalGrade(
    val provisionalGradeId: Int,
    val score: Double,
    val grade: String,
    val gradeMatchesCurrentSubmission: Boolean,
    val gradedAt: Instant,
    val final: Boolean,
    val speedgraderUrl: String,
)

fun ProvisionalGradeEntity.translate(): ProvisionalGrade {
    return ProvisionalGrade(
        provisionalGradeId = provisionalGradeId,
        score = score,
        grade = grade,
        gradeMatchesCurrentSubmission = gradeMatchesCurrentSubmission,
        gradedAt = Instant.parse(gradedAt),
        final = final,
        speedgraderUrl = speedgraderUrl,
    )
}
