package me.matsumo.klms.core.model.syllabus

import kotlinx.serialization.Serializable

@Serializable
data class SyllabusItems(
    val actionId: String,
    val ajaxResponse: String, // Consider a more descriptive type if the format is known
    val currentDayOfTheWeek: String,
    val dayOfWeekCounts: DayOfWeekCounts,
    val kNumberExistence: String, // Not very descriptive, clarify if possible
    val isLoggedIn: String, // Consider boolean type
    val hasExcessData: Boolean,
    val highlightKeywords: List<String>,
    val requiresReload: Boolean,
    val messageType: String,
    val searchResultCount: Int,
    val searchResultDetails: List<SearchResultDetails>,
    val searchResultPageCount: Int,
    val searchResultTotalCount: Int,
    val searchResultType: String,
    val shiborLsLoginStatus: String // Not very descriptive, clarify if possible
) {
    @Serializable
    data class DayOfWeekCounts(
        val monday: Int,
        val tuesday: Int,
        val wednesday: Int,
        val thursday: Int,
        val friday: Int,
        val saturday: Int,
        val other: Int // Assume 'dow9' refers to other/unscheduled
    )

    @Serializable
    data class SearchResultDetails(
        val dayOfTheWeekCode: String,
        val dayOfTheWeekUrl: String,
        val dayOfTheWeekName: String,
        val courseDetails: List<Course>
    )

    @Serializable
    data class Course(
        val areaName: String,
        val classroom: String?,
        val credit: String,
        val courseNumber: Int,
        val dayOfTheWeekCode: String,
        val dayOfWeekCount: Int,
        val dayOfTheWeek: String,
        val entityNumber: String,
        val establishment: String,
        val establishmentCourseCode: String,
        val establishmentDepartmentCode: String,
        val establishmentFacultyCode: String,
        val establishmentProgramCode: String,
        val isFavorite: Boolean, // Assumed that FAVORITE_FLG indicates this
        val fieldName: String,
        val fridayCount: Int,
        val jsonRowKey: JsonRowKey,
        val teachingLanguage: String,
        val teachingMode: String,
        val courseId: String, // Assuming KNUMBER represents the Course ID
        val lecturerName: String,
        val lessonCode: Int,
        val level: String,
        val minorField1Code: String,
        val minorField2Code: String,
        val minorField3Code: String,
        val modifiedTimestamp: String,
        val mondayCount: Int,
        val openCourseSemesterCode: String,
        val openingDayAndPeriod: String,
        val otherCount: Int,
        val periodCode: String,
        val primaryEntityNumber: String?, // Assuming PENTNO is some sort of primary entity number
        val lecturerKana: String,
        val saturdayCount: Int,
        val courseName: String,
        val courseNameKana: String,
        val setCourse: String,
        val semester: String,
        val semesterCode: String,
        val courseSubtitle: String,
        val syllabusCode: String,
        val syllabusDetailUrl: String,
        val thursdayCount: Int,
        val timetableIndex: String,
        val timetableDayOfWeekIndex: String,
        val totalCount: Int,
        val year: Int,
        val tuesdayCount: Int,
        val wednesdayCount: Int
    )

    @Serializable
    data class JsonRowKey(
        val entityNumber: String,
        val year: Int
    )
}

fun SyllabusItemsEntity.translate(): SyllabusItems {
    return SyllabusItems(
        actionId = this.actionId,
        ajaxResponse = this.ajaxRs,
        currentDayOfTheWeek = this.currentDow,
        dayOfWeekCounts = SyllabusItems.DayOfWeekCounts(
            monday = this.dowCntData.dow1,
            tuesday = this.dowCntData.dow2,
            wednesday = this.dowCntData.dow3,
            thursday = this.dowCntData.dow4,
            friday = this.dowCntData.dow5,
            saturday = this.dowCntData.dow6,
            other = this.dowCntData.dow9
        ),
        kNumberExistence = this.knumberExistTtblyr,
        isLoggedIn = this.loginedFlg,
        hasExcessData = this.maxDataCountExcessFlg == "true", // Assuming flag comparison
        highlightKeywords = this.highlightKeywords,
        requiresReload = this.msgReloadFlg,
        messageType = this.msgType,
        searchResultCount = this.searchResultDowCnt,
        searchResultDetails = this.searchResultDs.map { searchResultD ->
            SyllabusItems.SearchResultDetails(
                dayOfTheWeekCode = searchResultD.dowcd,
                dayOfTheWeekUrl = searchResultD.dowpdHref,
                dayOfTheWeekName = searchResultD.dowpdNm,
                courseDetails = searchResultD.sbjtDs.map { sbjtD ->
                    SyllabusItems.Course(
                        areaName = sbjtD.aREANM,
                        classroom = sbjtD.cLRM,
                        credit = sbjtD.cREDIT,
                        courseNumber = sbjtD.cURRINO,
                        dayOfTheWeekCode = sbjtD.dOWCD,
                        dayOfWeekCount = sbjtD.dOWCNT,
                        dayOfTheWeek = sbjtD.dOWPD,
                        entityNumber = sbjtD.eNTNO,
                        establishment = sbjtD.eSTB,
                        establishmentCourseCode = sbjtD.eSTBCOSECD,
                        establishmentDepartmentCode = sbjtD.eSTBDEPCD,
                        establishmentFacultyCode = sbjtD.eSTBFCD,
                        establishmentProgramCode = sbjtD.eSTBPRGCD,
                        isFavorite = sbjtD.fAVORITEFLG == "1", // Assuming '1' indicates favorite
                        fieldName = sbjtD.fLDNM,
                        fridayCount = sbjtD.fRICNT,
                        jsonRowKey = SyllabusItems.JsonRowKey(
                            entityNumber = sbjtD.jSONROWKEY.eNTNO,
                            year = sbjtD.jSONROWKEY.tTBLYR,
                        ),
                        teachingLanguage = sbjtD.kNLESSONLANGNM,
                        teachingMode = sbjtD.kNLESSONMODENM,
                        courseId = sbjtD.kNUMBER,
                        lecturerName = sbjtD.lCTNM,
                        lessonCode = sbjtD.lESSONCD,
                        level = sbjtD.lVL,
                        minorField1Code = sbjtD.mINFLD1CD,
                        minorField2Code = sbjtD.mINFLD2CD,
                        minorField3Code = sbjtD.mINFLD3CD,
                        modifiedTimestamp = sbjtD.mODTS,
                        mondayCount = sbjtD.mONCNT,
                        openCourseSemesterCode = sbjtD.oPNCOUSSMSCD,
                        openingDayAndPeriod = sbjtD.oPNDAYPD,
                        otherCount = sbjtD.oTHERCNT,
                        periodCode = sbjtD.pDCD,
                        primaryEntityNumber = sbjtD.pENTNO,
                        lecturerKana = sbjtD.pSNNMKN,
                        saturdayCount = sbjtD.sATCNT,
                        courseName = sbjtD.sBJTNM,
                        courseNameKana = sbjtD.sBJTNMKN,
                        setCourse = sbjtD.sETCOURSE,
                        semester = sbjtD.sMS,
                        semesterCode = sbjtD.sMSCD,
                        courseSubtitle = sbjtD.sUBTITLE,
                        syllabusCode = sbjtD.sYLLABUSCD,
                        syllabusDetailUrl = sbjtD.sYLLABUSDETAILURL,
                        thursdayCount = sbjtD.tHUCNT,
                        timetableIndex = sbjtD.tIMETABLEINDEX,
                        timetableDayOfWeekIndex = sbjtD.tIMETABLEYOUBIINDEX,
                        totalCount = sbjtD.tOTALCNT,
                        year = sbjtD.tTBLYR,
                        tuesdayCount = sbjtD.tUECNT,
                        wednesdayCount = sbjtD.wEDCNT
                    )
                }
            )
        },
        searchResultPageCount = this.searchResultPageCount,
        searchResultTotalCount = this.searchResultTotalCnt,
        searchResultType = this.searchResultType,
        shiborLsLoginStatus = this.shibOrLsLoginedFlg
    )
}
