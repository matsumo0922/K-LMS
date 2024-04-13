package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleItemSequenceEntity(
    @SerialName("items")
    val items: List<ModuleItemSequenceEntity.ModuleItemSequenceNode>,
    @SerialName("modules")
    val modules: List<ModuleEntity>,
) {

    @Serializable
    data class ModuleItemSequenceNode(
        @SerialName("prev")
        val prev: ModuleItemEntity? = null,
        @SerialName("current")
        val current: ModuleItemEntity,
        @SerialName("next")
        val next: ModuleItemEntity? = null,
        @SerialName("mastery_path")
        val masteryPath: MasteryPath,
    )

    @Serializable
    data class MasteryPath(
        @SerialName("locked")
        val locked: Boolean,
        @SerialName("assignment_sets")
        val assignmentSets: List<AssignmentEntity>, // Placeholder - model based on structure

        @SerialName("selected_set_id")
        val selectedSetId: Int? = null,
        @SerialName("awaiting_choice")
        val awaitingChoice: Boolean,
        @SerialName("still_processing")
        val stillProcessing: Boolean,
        @SerialName("modules_url")
        val modulesUrl: String,
        @SerialName("choose_url")
        val chooseUrl: String,
        @SerialName("modules_tab_disabled")
        val modulesTabDisabled: Boolean,
    )
}
