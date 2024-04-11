package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizPermissions(
        val read: Boolean,

        val submit: Boolean,

        val create: Boolean,

        val manage: Boolean,

        val readStatistics: Boolean,

        val reviewGrades: Boolean,

        val update: Boolean
)

fun QuizPermissionsEntity.translate(): QuizPermissions {
    return QuizPermissions(
        read = read,
        submit = submit,
        create = create,
        manage = manage,
        readStatistics = readStatistics,
        reviewGrades = reviewGrades
    )
}
