package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Associates a course with a blueprint.
@Serializable
data class BlueprintSubscriptionEntity(
    // The ID of the blueprint course subscription.
    @SerialName("id") val id: Int,
    // The ID of the blueprint template the associated course is subscribed to.
    @SerialName("template_id") val templateId: Int,
    // The blueprint course subscribed to.
    @SerialName("blueprint_course") val blueprintCourse:
    me.matsumo.klms.core.model.lms.entity.BlueprintSubscriptionEntity.BlueprintCourse,
) {
    @Serializable
    data class BlueprintCourse(
        // The ID of the blueprint course.
        @SerialName("id") val id: Int,
        // The name of the blueprint course.
        @SerialName("name") val name: String,
        // The course code of the blueprint course.
        @SerialName("course_code") val courseCode: String,
        // The term name of the blueprint course.
        @SerialName("term_name") val termName: String,
    )
}
