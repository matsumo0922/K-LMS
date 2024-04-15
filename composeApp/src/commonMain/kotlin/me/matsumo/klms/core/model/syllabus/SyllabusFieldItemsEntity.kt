package me.matsumo.klms.core.model.syllabus


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SyllabusFieldItemsEntity(
    @SerialName("action_id")
    val actionId: String,
    @SerialName("ajax_rs")
    val ajaxRs: String,
    @SerialName("changeTargetRs")
    val changeTargetRs: ChangeTargetRs,
    @SerialName("msgReloadFlg")
    val msgReloadFlg: Boolean,
    @SerialName("msgType")
    val msgType: String
) {
    @Serializable
    data class ChangeTargetRs(
        @SerialName("KEYWORD_FLD2CD")
        val kEYWORDFLD2CD: String,
        @SerialName("KEYWORD_FLD2CD_ITEM")
        val kEYWORDFLD2CDITEM: List<KEYWORDFLD2CDITEM>
    ) {
        @Serializable
        data class KEYWORDFLD2CDITEM(
            @SerialName("name")
            val name: String,
            @SerialName("ROW_INDEX_KEY")
            val rOWINDEXKEY: String?,
            @SerialName("value")
            val value: String
        )
    }
}
