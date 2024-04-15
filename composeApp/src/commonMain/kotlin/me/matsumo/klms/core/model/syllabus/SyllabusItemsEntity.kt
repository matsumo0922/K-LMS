package me.matsumo.klms.core.model.syllabus


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SyllabusItemsEntity(
    @SerialName("action_id")
    val actionId: String,
    @SerialName("ajax_rs")
    val ajaxRs: String,
    @SerialName("currentDow")
    val currentDow: String,
    @SerialName("dowCntData")
    val dowCntData: DowCntData,
    @SerialName("highlightKeywords")
    val highlightKeywords: List<String>,
    @SerialName("knumberExistTtblyr")
    val knumberExistTtblyr: String,
    @SerialName("loginedFlg")
    val loginedFlg: String,
    @SerialName("maxDataCountExcessFlg")
    val maxDataCountExcessFlg: String,
    @SerialName("msgReloadFlg")
    val msgReloadFlg: Boolean,
    @SerialName("msgType")
    val msgType: String,
    @SerialName("searchResultDowCnt")
    val searchResultDowCnt: Int,
    @SerialName("searchResultDs")
    val searchResultDs: List<SearchResultD>,
    @SerialName("searchResultPageCount")
    val searchResultPageCount: Int,
    @SerialName("searchResultTotalCnt")
    val searchResultTotalCnt: Int,
    @SerialName("searchResultType")
    val searchResultType: String,
    @SerialName("shibOrLsLoginedFlg")
    val shibOrLsLoginedFlg: String
) {
    @Serializable
    data class DowCntData(
        @SerialName("dow1")
        val dow1: Int,
        @SerialName("dow2")
        val dow2: Int,
        @SerialName("dow3")
        val dow3: Int,
        @SerialName("dow4")
        val dow4: Int,
        @SerialName("dow5")
        val dow5: Int,
        @SerialName("dow6")
        val dow6: Int,
        @SerialName("dow9")
        val dow9: Int
    )

    @Serializable
    data class SearchResultD(
        @SerialName("dowcd")
        val dowcd: String,
        @SerialName("dowpdHref")
        val dowpdHref: String,
        @SerialName("dowpdNm")
        val dowpdNm: String,
        @SerialName("sbjtDs")
        val sbjtDs: List<SbjtD>
    ) {
        @Serializable
        data class SbjtD(
            @SerialName("AREANM")
            val aREANM: String,
            @SerialName("CLRM")
            val cLRM: String?,
            @SerialName("CREDIT")
            val cREDIT: String,
            @SerialName("CURRINO")
            val cURRINO: Int,
            @SerialName("DOWCD")
            val dOWCD: String,
            @SerialName("DOW_CNT")
            val dOWCNT: Int,
            @SerialName("DOWPD")
            val dOWPD: String,
            @SerialName("ENTNO")
            val eNTNO: String,
            @SerialName("ESTB")
            val eSTB: String,
            @SerialName("ESTBCOSECD")
            val eSTBCOSECD: String,
            @SerialName("ESTBDEPCD")
            val eSTBDEPCD: String,
            @SerialName("ESTBFCD")
            val eSTBFCD: String,
            @SerialName("ESTBPRGCD")
            val eSTBPRGCD: String,
            @SerialName("FAVORITE_FLG")
            val fAVORITEFLG: String,
            @SerialName("FLDNM")
            val fLDNM: String,
            @SerialName("FRI_CNT")
            val fRICNT: Int,
            @SerialName("JSON_ROW_KEY")
            val jSONROWKEY: JSONROWKEY,
            @SerialName("KNLESSONLANGNM")
            val kNLESSONLANGNM: String,
            @SerialName("KNLESSONMODENM")
            val kNLESSONMODENM: String,
            @SerialName("KNUMBER")
            val kNUMBER: String,
            @SerialName("LCTNM")
            val lCTNM: String,
            @SerialName("LESSONCD")
            val lESSONCD: Int,
            @SerialName("LVL")
            val lVL: String,
            @SerialName("MINFLD1CD")
            val mINFLD1CD: String,
            @SerialName("MINFLD2CD")
            val mINFLD2CD: String,
            @SerialName("MINFLD3CD")
            val mINFLD3CD: String,
            @SerialName("MODTS")
            val mODTS: String,
            @SerialName("MON_CNT")
            val mONCNT: Int,
            @SerialName("OPNCOUSSMSCD")
            val oPNCOUSSMSCD: String,
            @SerialName("OPNDAYPD")
            val oPNDAYPD: String,
            @SerialName("OTHER_CNT")
            val oTHERCNT: Int,
            @SerialName("PDCD")
            val pDCD: String,
            @SerialName("PENTNO")
            val pENTNO: String?,
            @SerialName("PSNNM_KN")
            val pSNNMKN: String,
            @SerialName("SAT_CNT")
            val sATCNT: Int,
            @SerialName("SBJTNM")
            val sBJTNM: String,
            @SerialName("SBJTNM_KN")
            val sBJTNMKN: String,
            @SerialName("SETCOURSE")
            val sETCOURSE: String,
            @SerialName("SMS")
            val sMS: String,
            @SerialName("SMSCD")
            val sMSCD: String,
            @SerialName("SUBTITLE")
            val sUBTITLE: String,
            @SerialName("SYLLABUSCD")
            val sYLLABUSCD: String,
            @SerialName("SYLLABUS_DETAIL_URL")
            val sYLLABUSDETAILURL: String,
            @SerialName("THU_CNT")
            val tHUCNT: Int,
            @SerialName("TIMETABLE_INDEX")
            val tIMETABLEINDEX: String,
            @SerialName("TIMETABLE_YOUBI_INDEX")
            val tIMETABLEYOUBIINDEX: String,
            @SerialName("TOTAL_CNT")
            val tOTALCNT: Int,
            @SerialName("TTBLYR")
            val tTBLYR: Int,
            @SerialName("TUE_CNT")
            val tUECNT: Int,
            @SerialName("WED_CNT")
            val wEDCNT: Int
        ) {
            @Serializable
            data class JSONROWKEY(
                @SerialName("ENTNO")
                val eNTNO: String,
                @SerialName("TTBLYR")
                val tTBLYR: Int
            )
        }
    }
}
