package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MigratorEntity(
    // The value to pass to the create endpoint
    @SerialName("type")
    val type: String,

    // Whether this endpoint requires a file upload
    @SerialName("requires_file_upload")
    val requiresFileUpload: Boolean,

    // Description of the package type expected
    @SerialName("name")
    val name: String,

    // A list of fields this system requires
    @SerialName("required_settings")
    val requiredSettings: List<String>
)
