package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EnrollmentTermEntity

@Serializable
data class EnrollmentTerm(
    val id: Int,
    val sisTermId: String? = null,
    val sisImportId: Int? = null,
    val name: String,
    val startAt: String,
    val endAt: String,
    val workflowState: String,
    val overrides: Overrides,
    val courseCount: Int?,
) {

    @Serializable
    data class Overrides(
        val studentEnrollment: StudentEnrollmentOverrides,
    )

    @Serializable
    data class StudentEnrollmentOverrides(
        val startAt: String,
        val endAt: String,
    )
}

fun EnrollmentTermEntity.translate(): EnrollmentTerm {
    return EnrollmentTerm(
        id = id,
        sisTermId = sisTermId,
        sisImportId = sisImportId,
        name = name,
        startAt = startAt,
        endAt = endAt,
        workflowState = workflowState,
        overrides = EnrollmentTerm.Overrides(
            studentEnrollment = EnrollmentTerm.StudentEnrollmentOverrides(
                startAt = overrides.studentEnrollment.startAt,
                endAt = overrides.studentEnrollment.endAt,
            ),
        ),
        courseCount = courseCount,
    )
}
