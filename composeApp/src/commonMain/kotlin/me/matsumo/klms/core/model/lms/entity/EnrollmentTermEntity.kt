package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EnrollmentTermEntity(
    // The unique identifier for the enrollment term.
    @SerialName("id")
    val id: Int,
    // The SIS id of the term. ...
    @SerialName("sis_term_id")
    val sisTermId: String? = null,
    // the unique identifier for the SIS import. ...
    @SerialName("sis_import_id")
    val sisImportId: Int? = null,
    // The name of the term.
    @SerialName("name")
    val name: String,
    // The datetime of the start of the term.
    @SerialName("start_at")
    val startAt: String,
    // The datetime of the end of the term.
    @SerialName("end_at")
    val endAt: String,
    // The state of the term. ...
    @SerialName("workflow_state")
    val workflowState: String,
    // Term date overrides for specific enrollment types
    @SerialName("overrides")
    val overrides: me.matsumo.klms.core.model.lms.entity.EnrollmentTermEntity.Overrides,
    // The number of courses in the term ...
    @SerialName("course_count")
    val courseCount: Int?,
) {

    @Serializable
    data class Overrides(
        @SerialName("StudentEnrollment")
        val studentEnrollment: me.matsumo.klms.core.model.lms.entity.EnrollmentTermEntity.StudentEnrollmentOverrides,
    )

    @Serializable
    data class StudentEnrollmentOverrides(
        @SerialName("start_at")
        val startAt: String,
        @SerialName("end_at")
        val endAt: String,
    )
}
