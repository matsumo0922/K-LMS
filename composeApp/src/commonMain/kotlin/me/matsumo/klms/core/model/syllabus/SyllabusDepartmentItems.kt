package me.matsumo.klms.core.model.syllabus

import kotlinx.serialization.Serializable

@Serializable
data class SyllabusDepartmentItems(
    val actionId: String,
    val ajaxResponse: String, // Consider a more descriptive type if the format is known
    val changeTarget: ChangeTarget,
    val requiresReload: Boolean,
    val messageType: String
) {
    @Serializable
    data class ChangeTarget(
        val departmentCodes: List<String>,
        val departmentItems: List<DepartmentItem>,
        val field1Code: String,
        val field1Items: List<FieldItem>,
        val field2Code: String,
        val field2Items: List<FieldItem>,
        val screenGroupType: String,
        val screenGroupItems: List<ScreenGroupItem>
    )

    @Serializable
    data class DepartmentItem(
        val name: String,
        val rowIndexKey: String, // Consider a more specific type if possible
        val value: String
    )

    @Serializable
    data class FieldItem(
        val name: String,
        val rowIndexKey: String?, // Consider a more specific type if possible
        val value: String
    )

    @Serializable
    data class ScreenGroupItem(
        val name: String,
        val rowIndexKey: String?, // Consider a more specific type if possible
        val value: String
    )
}

fun SyllabusDepartmentItemsEntity.translate(): SyllabusDepartmentItems {
    return SyllabusDepartmentItems(
        actionId = this.actionId,
        ajaxResponse = this.ajaxRs,
        changeTarget = SyllabusDepartmentItems.ChangeTarget(
            departmentCodes = this.changeTargetRs.kEYWORDDEPCD,
            departmentItems = this.changeTargetRs.kEYWORDDEPCDITEM.map { item ->
                SyllabusDepartmentItems.DepartmentItem(
                    name = item.name,
                    rowIndexKey = item.rOWINDEXKEY,
                    value = item.value,
                )
            },
            field1Code = this.changeTargetRs.kEYWORDFLD1CD,
            field1Items = this.changeTargetRs.kEYWORDFLD1CDITEM.map { item ->
                SyllabusDepartmentItems.FieldItem(
                    name = item.name,
                    rowIndexKey = item.rOWINDEXKEY,
                    value = item.value
                )
            },
            field2Code = this.changeTargetRs.kEYWORDFLD2CD,
            field2Items = this.changeTargetRs.kEYWORDFLD2CDITEM.map { item ->
                SyllabusDepartmentItems.FieldItem(
                    name = item.name,
                    rowIndexKey = null,
                    value = item.value
                )
            },
            screenGroupType = this.changeTargetRs.kEYWORDSCRGUTP,
            screenGroupItems = this.changeTargetRs.kEYWORDSCRGUTPITEM.map { item ->
                SyllabusDepartmentItems.ScreenGroupItem(
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
