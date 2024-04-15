package me.matsumo.klms.core.model.syllabus

import kotlinx.serialization.Serializable

@Serializable
data class SyllabusFieldItems(
    val actionId: String,
    val ajaxResponse: String, // Consider a more descriptive type if the format is known
    val changeTarget: ChangeTarget,
    val requiresReload: Boolean,
    val messageType: String
) {
    @Serializable
    data class ChangeTarget(
        val field2Code: String,
        val field2Items: List<FieldItem>
    )

    @Serializable
    data class FieldItem(
        val name: String,
        val rowIndexKey: String?,
        val value: String
    )
}

fun SyllabusFieldItemsEntity.translate(): SyllabusFieldItems {
    return SyllabusFieldItems(
        actionId = this.actionId,
        ajaxResponse = this.ajaxRs,
        changeTarget = SyllabusFieldItems.ChangeTarget(
            field2Code = this.changeTargetRs.kEYWORDFLD2CD,
            field2Items = this.changeTargetRs.kEYWORDFLD2CDITEM.map { item ->
                SyllabusFieldItems.FieldItem(
                    name = item.name,
                    rowIndexKey = item.rOWINDEXKEY,
                    value = item.value
                )
            }
        ),
        requiresReload = this.msgReloadFlg,
        messageType = this.msgType
    )
}
