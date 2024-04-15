package me.matsumo.klms.core.model.syllabus


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SyllabusDepartmentItemsEntity(
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
        @SerialName("KEYWORD_DEPCD")
        val kEYWORDDEPCD: List<String>,
        @SerialName("KEYWORD_DEPCD_ITEM")
        val kEYWORDDEPCDITEM: List<KEYWORDDEPCDITEM>,
        @SerialName("KEYWORD_FLD1CD")
        val kEYWORDFLD1CD: String,
        @SerialName("KEYWORD_FLD1CD_ITEM")
        val kEYWORDFLD1CDITEM: List<KEYWORDFLD1CDITEM>,
        @SerialName("KEYWORD_FLD2CD")
        val kEYWORDFLD2CD: String,
        @SerialName("KEYWORD_FLD2CD_ITEM")
        val kEYWORDFLD2CDITEM: List<KEYWORDFLD2CDITEM>,
        @SerialName("KEYWORD_SCRGUTP")
        val kEYWORDSCRGUTP: String,
        @SerialName("KEYWORD_SCRGUTP_ITEM")
        val kEYWORDSCRGUTPITEM: List<KEYWORDSCRGUTPITEM>
    ) {
        @Serializable
        data class KEYWORDDEPCDITEM(
            @SerialName("name")
            val name: String,
            @SerialName("ROW_INDEX_KEY")
            val rOWINDEXKEY: String,
            @SerialName("value")
            val value: String
        )

        @Serializable
        data class KEYWORDFLD1CDITEM(
            @SerialName("name")
            val name: String,
            @SerialName("ROW_INDEX_KEY")
            val rOWINDEXKEY: String?,
            @SerialName("value")
            val value: String
        )

        @Serializable
        data class KEYWORDFLD2CDITEM(
            @SerialName("name")
            val name: String,
            @SerialName("value")
            val value: String
        )

        @Serializable
        data class KEYWORDSCRGUTPITEM(
            @SerialName("name")
            val name: String,
            @SerialName("ROW_INDEX_KEY")
            val rOWINDEXKEY: String?,
            @SerialName("value")
            val value: String
        )
    }
}
