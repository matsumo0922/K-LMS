package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleItemSequenceEntity(
    @SerialName("items")
    val items: List<ModuleItemSequenceNode>,

    @SerialName("modules")
    val modules: List<Module>
) {

    @Serializable
    data class ModuleItemSequenceNode(
        @SerialName("prev")
        val prev: ModuleItem? = null,

        @SerialName("current")
        val current: ModuleItem,

        @SerialName("next")
        val next: ModuleItem? = null,

        @SerialName("mastery_path")
        val masteryPath: MasteryPath
    )

    @Serializable
    data class MasteryPath(
        @SerialName("locked")
        val locked: Boolean,

        @SerialName("assignment_sets")
        val assignmentSets: List<Any>, // Placeholder - model based on structure

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
        val modulesTabDisabled: Boolean
    )

    @Serializable
    data class Module(
        @SerialName("id")
        val id: Int,

        @SerialName("name")
        val name: String
    )

    @Serializable
    data class ModuleItem(
        @SerialName("id")
        val id: Int,

        @SerialName("module_id")
        val moduleId: Int,

        @SerialName("title")
        val title: String,

        @SerialName("type")
        val type: String
    )
}
