package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnrollmentTermsListEntity(
    @SerialName("enrollment_terms")
    val enrollmentTerms: List<me.matsumo.klms.core.model.lms.entity.EnrollmentTermEntity>,
)

// ... (You'll need the 'EnrollmentTerm' data class from the previous example)
