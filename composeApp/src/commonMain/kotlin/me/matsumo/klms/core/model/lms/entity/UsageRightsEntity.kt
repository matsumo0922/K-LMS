package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsageRightsEntity(
    // Copyright line for the file
    @SerialName("legal_copyright")
    val legalCopyright: String,
    // Justification for using the file in a Canvas course. ...
    @SerialName("use_justification")
    val useJustification: String,
    // License identifier for the file.
    @SerialName("license")
    val license: String,
    // Readable license name
    @SerialName("license_name")
    val licenseName: String,
    // Explanation of the action performed
    @SerialName("message")
    val message: String,
    // List of ids of files that were updated
    @SerialName("file_ids")
    val fileIds: List<Int>,
)
