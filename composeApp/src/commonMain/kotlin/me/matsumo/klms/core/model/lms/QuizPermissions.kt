package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.QuizPermissionsEntity

@Serializable
data class QuizPermissions(
    val read: Boolean,
    val submit: Boolean,
    val create: Boolean,
    val manage: Boolean,
    val readStatistics: Boolean,
    val reviewGrades: Boolean,
    val update: Boolean,
)

fun QuizPermissionsEntity.translate(): QuizPermissions {
    return QuizPermissions(
        read = read,
        submit = submit,
        create = create,
        manage = manage,
        readStatistics = readStatistics,
        reviewGrades = reviewGrades,
        update = update,
    )
}
