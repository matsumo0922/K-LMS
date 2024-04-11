package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseEpubExport(
        val id: Int,

        val name: String,

        val epubExport: EPubExportEntity? = null
)

fun CourseEpubExportEntity.translate(): CourseEpubExport {
    return CourseEpubExport(
        id = id,
        name = name
    )
}
