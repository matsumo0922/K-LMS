package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Describes a learning object change propagated to associated courses from a blueprint course.
@Serializable
data class ChangeRecordEntity(
    // The ID of the learning object that was changed in the blueprint course.
    @SerialName("asset_id") val assetId: Int,
    // The type of the learning object that was changed.
    @SerialName("asset_type") val assetType: String,
    // The name of the learning object that was changed in the blueprint course.
    @SerialName("asset_name") val assetName: String,
    // The type of change.
    @SerialName("change_type") val changeType: String,
    // The URL of the changed object
    @SerialName("html_url") val htmlUrl: String,
    // Whether the object is locked in the blueprint
    @SerialName("locked") val locked: Boolean,
    // A list of ExceptionRecords for linked courses that did not receive this update.
    @SerialName("exceptions") val exceptions: List<ExceptionRecordEntity>,
)
