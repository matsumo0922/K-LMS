package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.CourseEpubExportEntity

@Serializable
data class CourseEpubExport(
    val id: Int,
    val name: String,
    val epubExport: EPubExport? = null,
)

fun CourseEpubExportEntity.translate(): CourseEpubExport {
    return CourseEpubExport(
        id = id,
        name = name,
        epubExport = epubExport?.translate(),
    )
}
