package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.EnrollmentTermsListEntity

@Serializable
data class EnrollmentTermsList(
    val enrollmentTerms: List<EnrollmentTerm>,
)

fun EnrollmentTermsListEntity.translate(): EnrollmentTermsList {
    return EnrollmentTermsList(
        enrollmentTerms = enrollmentTerms.map { it.translate() },
    )
}
