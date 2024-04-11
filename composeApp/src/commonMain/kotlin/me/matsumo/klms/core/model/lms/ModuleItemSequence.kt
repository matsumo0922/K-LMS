package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ModuleItemSequence(
    val items: List<ModuleItemSequenceNode>,

    val modules: List<ModuleEntity>
) {

    @Serializable
    data class ModuleItemSequenceNode(
        val prev: ModuleItem? = null,

        val current: ModuleItem,

        val next: ModuleItem? = null,

        val masteryPath: MasteryPath
    )

    @Serializable
    data class MasteryPath(
        val locked: Boolean,

        val assignmentSets: List<AssignmentEntity>, 
        val selectedSetId: Int? = null,

        val awaitingChoice: Boolean,

        val stillProcessing: Boolean,

        val modulesUrl: String,

        val chooseUrl: String,

        val modulesTabDisabled: Boolean
    )

    @Serializable
    data class Module(
        val id: Int,

        val name: String
    )

    @Serializable
    data class ModuleItem(
        val id: Int,

        val moduleId: Int,

        val title: String,

        val type: String
    )
}

fun ModuleItemSequenceEntity.translate(): ModuleItemSequence {
    return ModuleItemSequence(
        items = items,
        prev = prev,
        current = current,
        next = next,
        locked = locked,
        assignmentSets = assignmentSets,
        selectedSetId = selectedSetId,
        awaitingChoice = awaitingChoice,
        stillProcessing = stillProcessing,
        modulesUrl = modulesUrl,
        chooseUrl = chooseUrl,
        id = id,
        id = id,
        moduleId = moduleId,
        title = title
    )
}
