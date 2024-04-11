package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnrollmentTermsList(
    val enrollmentTerms: List<EnrollmentTermEntity>
)


fun EnrollmentTermsListEntity.translate(): EnrollmentTermsList {
    return EnrollmentTermsList(
        
    )
}
