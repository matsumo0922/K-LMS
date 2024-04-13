package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ModuleItemSequenceEntity

@Serializable
data class ModuleItemSequence(
    val items: List<ModuleItemSequenceNode>,
    val modules: List<LmsModule>,
) {

    @Serializable
    data class ModuleItemSequenceNode(
        val prev: ModuleItem? = null,
        val current: ModuleItem,
        val next: ModuleItem? = null,
        val masteryPath: MasteryPath,
    )

    @Serializable
    data class MasteryPath(
        val locked: Boolean,
        val assignmentSets: List<Assignment>,
        val selectedSetId: Int? = null,
        val awaitingChoice: Boolean,
        val stillProcessing: Boolean,
        val modulesUrl: String,
        val chooseUrl: String,
        val modulesTabDisabled: Boolean,
    )
}

fun ModuleItemSequenceEntity.translate(): ModuleItemSequence {
    return ModuleItemSequence(
        items = items.map { item ->
            ModuleItemSequence.ModuleItemSequenceNode(
                prev = item.prev?.translate(),
                current = item.current.translate(),
                next = item.next?.translate(),
                masteryPath = ModuleItemSequence.MasteryPath(
                    locked = item.masteryPath.locked,
                    assignmentSets = item.masteryPath.assignmentSets.map { it.translate() },
                    selectedSetId = item.masteryPath.selectedSetId,
                    awaitingChoice = item.masteryPath.awaitingChoice,
                    stillProcessing = item.masteryPath.stillProcessing,
                    modulesUrl = item.masteryPath.modulesUrl,
                    chooseUrl = item.masteryPath.chooseUrl,
                    modulesTabDisabled = item.masteryPath.modulesTabDisabled,
                ),
            )
        },
        modules = modules.map { it.translate() },
    )
}
