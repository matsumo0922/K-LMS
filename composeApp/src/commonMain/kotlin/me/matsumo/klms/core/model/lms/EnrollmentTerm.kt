package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EnrollmentTermEntity

@Serializable
data class EnrollmentTerm(
    val id: Int,
    val sisTermId: String? = null,
    val sisImportId: Int? = null,
    val name: String,
    val startAt: Instant,
    val endAt: Instant,
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
        val startAt: Instant,
        val endAt: Instant,
    )
}

fun EnrollmentTermEntity.translate(): EnrollmentTerm {
    return EnrollmentTerm(
        id = id,
        sisTermId = sisTermId,
        sisImportId = sisImportId,
        name = name,
        startAt = Instant.parse(startAt),
        endAt = Instant.parse(endAt),
        workflowState = workflowState,
        overrides = EnrollmentTerm.Overrides(
            studentEnrollment = EnrollmentTerm.StudentEnrollmentOverrides(
                startAt = Instant.parse(overrides.studentEnrollment.startAt),
                endAt = Instant.parse(overrides.studentEnrollment.endAt),
            ),
        ),
        courseCount = courseCount,
    )
}
