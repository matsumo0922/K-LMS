package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineItemEntity(
    // The fully qualified URL ...
    @SerialName("id")
    val id: String,

    // The maximum score of the Line Item
    @SerialName("scoreMaximum")
    val scoreMaximum: Double,

    // The label of the Line Item.
    @SerialName("label")
    val label: String,

    // Tag used to qualify a line Item...
    @SerialName("tag")
    val tag: String,

    // A Tool Provider specified id ...
    @SerialName("resourceId")
    val resourceId: String,

    // The resource link id the Line Item ...
    @SerialName("resourceLinkId")
    val resourceLinkId: String,

    // The extension that defines the submission_type...
    @SerialName("https://canvas.instructure.com/lti/submission_type")
    val submissionType: SubmissionType? = null ,

    // The launch url of the Line Item ...
    @SerialName("https://canvas.instructure.com/lti/launch_url")
    val launchUrl: String? = null
) {
    @Serializable
    data class SubmissionType(
        @SerialName("type")
        val type: String,

        @SerialName("external_tool_url")
        val externalToolUrl: String
    )
}
