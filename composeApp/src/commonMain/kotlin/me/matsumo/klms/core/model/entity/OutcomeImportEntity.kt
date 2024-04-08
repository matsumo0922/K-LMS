package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutcomeImportEntity(
    // The unique identifier for the outcome import.
    @SerialName("id")
    val id: Int,

    // The unique identifier for the group
    @SerialName("learning_outcome_group_id")
    val learningOutcomeGroupId: Int?,

    //  The date the outcome import was created.
    @SerialName("created_at")
    val createdAt: String,

    //  The date the outcome import finished.
    @SerialName("ended_at")
    val endedAt: String?,

    //  The date the outcome import was last updated.
    @SerialName("updated_at")
    val updatedAt: String,

    //  The current state of the outcome import.
    @SerialName("workflow_state")
    val workflowState: String,

    //  See the OutcomeImportData specification
    @SerialName("data")
    val data: OutcomeImportDataEntity?,

    // The progress of the outcome import.
    @SerialName("progress")
    val progress: Int, // Representing percentage as an integer

    //  The user that initiated the outcome_import.
    @SerialName("user")
    val user: User?, // You'll likely have a 'User' data class

    // An array of row number / error message pairs.
    @SerialName("processing_errors")
    val processingErrors: List<List<Any>> // Using 'Any' as a placeholder until you have a specific structure
)

// You'll have the 'OutcomeImportData' class from a previous example

// Placeholder for a 'User' data class if you don't already have one
