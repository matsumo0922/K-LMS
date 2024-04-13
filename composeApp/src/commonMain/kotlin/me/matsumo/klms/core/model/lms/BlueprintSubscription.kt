package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.BlueprintSubscriptionEntity

@Serializable
data class BlueprintSubscription(
    val id: Int,
    val templateId: Int,
    val blueprintCourse: BlueprintCourse,
) {
    @Serializable
    data class BlueprintCourse(
        val id: Int,
        val name: String,
        val courseCode: String,
        val termName: String,
    )
}

fun BlueprintSubscriptionEntity.translate(): BlueprintSubscription {
    return BlueprintSubscription(
        id = id,
        templateId = templateId,
        blueprintCourse = BlueprintSubscription.BlueprintCourse(
            id = blueprintCourse.id,
            name = blueprintCourse.name,
            courseCode = blueprintCourse.courseCode,
            termName = blueprintCourse.termName,
        ),
    )
}
