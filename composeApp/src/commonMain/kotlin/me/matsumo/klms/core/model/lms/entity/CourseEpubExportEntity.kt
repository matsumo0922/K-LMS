package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseEpubExportEntity(
    // the unique identifier for the course
    @SerialName("id")
    val id: Int,
    // the name for the course
    @SerialName("name")
    val name: String,
    // ePub export API object
    @SerialName("epub_export")
    val epubExport: me.matsumo.klms.core.model.lms.entity.EPubExportEntity? = null,
)
