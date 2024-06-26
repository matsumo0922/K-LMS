package me.matsumo.klms.core.repository.api

import com.fleeksoft.ksoup.Ksoup
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.JsonNull.content
import me.matsumo.klms.core.extensions.parse
import me.matsumo.klms.core.model.syllabus.SyllabusDepartmentItems
import me.matsumo.klms.core.model.syllabus.SyllabusDepartmentItemsEntity
import me.matsumo.klms.core.model.syllabus.SyllabusDetail
import me.matsumo.klms.core.model.syllabus.SyllabusFieldItems
import me.matsumo.klms.core.model.syllabus.SyllabusFieldItemsEntity
import me.matsumo.klms.core.model.syllabus.SyllabusItems
import me.matsumo.klms.core.model.syllabus.SyllabusItemsEntity
import me.matsumo.klms.core.model.syllabus.translate

class SyllabusApi(
    private val client: ApiClient,
) {
    suspend fun getSyllabus(params: SyllabusSearchParams = SyllabusSearchParams()): SyllabusItems {
        return client.form(
            url = "https://gslbs.keio.jp/syllabus/result",
            formParams = params.toParams()
        ).parse<SyllabusItemsEntity>()!!.translate()
    }

    suspend fun getDepartments(params: SyllabusSearchDepartmentParams): SyllabusDepartmentItems {
        return client.form(
            url = "https://gslbs.keio.jp/syllabus/search",
            formParams = params.toParams()
        ).parse<SyllabusDepartmentItemsEntity>()!!.translate()
    }

    suspend fun getFields(params: SyllabusSearchFieldParams): SyllabusFieldItems {
        return client.form(
            url = "https://gslbs.keio.jp/syllabus/search",
            formParams = params.toParams()
        ).parse<SyllabusFieldItemsEntity>()!!.translate()
    }

    suspend fun getDetail(year: String, id: String): SyllabusDetail {
        val response = client.get(
            url = "https://gslbs.keio.jp/syllabus/detail",
            params = listOf(
                "ttblyr" to year,
                "entno" to id,
                "lang" to "jp",
            )
        )

        val document = Ksoup.parse(response.bodyAsText())
        val className = document.getElementsByClass("class-name").text()
        val table = document.getElementsByClass("table table-sm").first()
        val details = table?.select("tr")?.map { it.select("th").text() to it.select("td").text() }?.toMap().orEmpty()

        val sections = document.getElementsByClass("syllabus-section")
        val syllabus = sections[0].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val activeLearning = sections[1].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val preparation = sections[2].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val grading = sections[4].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val textbook = sections[5].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val reference = sections[6].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val comment = sections[7].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }
        val question = sections[8].let { it.getElementsByClass("sub-title").text() to it.getElementsByClass("contents").text() }

        val contentTitle = sections[3].getElementsByClass("sub-title").text()
        val contentPlans = mutableMapOf<String, String>()

        for (content in sections[3].getElementsByClass("syllabus-plan-outer")) {
            val headings = content.getElementsByClass("syllabus-plan-heading").text()
            val plan = content.getElementsByClass("syllabus-plan-content").text()

            contentPlans += (headings to plan)
        }

        return SyllabusDetail(
            id = id,
            year = year,
            className = className,
            details = details,
            syllabus = syllabus,
            activeLearning = activeLearning,
            preparation = preparation,
            grading = grading,
            textbook = textbook,
            reference = reference,
            comment = comment,
            question = question,
            contents = contentTitle to contentPlans,
        )
    }

    private fun SyllabusSearchParams.toParams(): List<Pair<String, String>> {
        val params = mutableListOf(
            "ACTION_ID" to "SYLLABUS_SEARCH_RESULT",
            "SUB_ACTION_ID" to "SYLLABUS_SEARCH_KEYWORD_EXECUTE",
            "KEYWORD_TTBLYR" to year.toString(),
            "KEYWORD_SMSCD" to semester.id,
            "KEYWORD_HALFSEMESTER" to halfSemester.id,
            "KEYWORD_KBS_SMSCD" to "ALL",
            "KEYWORD_CAMPUS" to campus.id,
            "KEYWORD_PRGANDFCD" to faculty.fcd,
            "KEYWORD_KAMOKUNM" to subjectKeyword,
            "KEYWORD_TANTONM" to teacherKeyword,
            "KEYWORD_KEYWORD" to keyword,
            "KEYWORD_SCRGUTP" to "17",
            "KEYWORD_LESSONLANG" to lessonLanguage.id,
            "KEYWORD_FLD1CD" to field1.jp,
            "KEYWORD_FLD2CD" to field2.value,
            "KEYWORD_FLD1NM" to field1.jp,
            "KEYWORD_FLD2NM" to field2.value,
            "NARABIJUN" to "1",
            "SELECTED_TT_DWCD" to "1",
        )

        for (department in department) {
            params += "KEYWORD_DEPCD" to department.value
        }

        for (level in level) {
            params += "KEYWORD_LEVEL" to level.toString()
        }

        for (dayOfWeek in dayOfWeek) {
            params += "KEYWORD_DOWCD" to dayOfWeek.id
        }

        for (period in period) {
            params += "KEYWORD_PDCD" to period.id
        }

        for (lessonType in lessonType) {
            params += "KEYWORD_LESSONTYPE" to lessonType.id
        }

        return params
    }

    private fun SyllabusSearchDepartmentParams.toParams(): List<Pair<String, String>> {
        return listOf(
            "ACTION_ID" to "SYLLABUS_SEARCH_KEYWORD_CHANGE_ITEM",
            "CHANGE_TARGET_SRC" to "KEYWORD_PRGANDFCD",
            "KEYWORD_TTBLYR" to year.toString(),
            "KEYWORD_PRGANDFCD" to faculty,
            "KEYWORD_SCRGUTP" to "17",
            "KEYWORD_FLD1CD" to "ALL",
        )
    }

    private fun SyllabusSearchFieldParams.toParams(): List<Pair<String, String>> {
        return listOf(
            "ACTION_ID" to "SYLLABUS_SEARCH_KEYWORD_CHANGE_ITEM",
            "CHANGE_TARGET_SRC" to "KEYWORD_FLD1CD",
            "KEYWORD_TTBLYR" to year.toString(),
            "KEYWORD_PRGANDFCD" to faculty,
            "KEYWORD_SCRGUTP" to "17",
            "KEYWORD_FLD1CD" to keyword,
        )
    }

    data class SyllabusSearchParams(
        val year: Int = 2024,
        val semester: Semester = Semester.ALL,
        val halfSemester: HalfSemester = HalfSemester.ALL,
        val campus: Campus = Campus.ALL,
        val faculty: Faculty = Faculty.ALL,
        val department: List<SyllabusDepartmentItems.DepartmentItem> = emptyList(),
        val level: List<Int> = listOf(1, 2, 3, 4),
        val subjectKeyword: String = "",
        val teacherKeyword: String = "",
        val keyword: String = "",
        val dayOfWeek: List<DayOfWeek> = DayOfWeek.entries.toList(),
        val period: List<Period> = Period.entries,
        val lessonType: List<LessonType> = LessonType.entries.toList(),
        val lessonLanguage: LessonLanguage = LessonLanguage.ALL,
        val field1: Field = Field.All,
        val field2: SyllabusFieldItems.FieldItem = SyllabusFieldItems.FieldItem("", "", ""),
    ) {
        enum class Semester(val id: String) {
            ALL("ALL"),
            SPRING("3"),
            FALL("5"),
        }

        enum class HalfSemester(val id: String) {
            ALL("ALL"),
            FIRST("1"),
            SECOND("2"),
        }

        enum class Campus(val id: String) {
            ALL("ALL"),
            MITA("1"),
            HIYOSHI("2"),
            SFC("4"),
            YAGAMI("5"),
            SHINANOMACHI("6"),
            SHIBA("7"),
        }

        enum class Faculty(
            val value: String,
            val fcd: String,
            val prgcd: String,
            val data: String
        ) {
            ALL("", "", "", ""),
            LITERATURE("11__02", "02", "11", "文学部"),
            ECONOMICS("11__06", "06", "11", "経済学部"),
            LAW("11__08", "08", "11", "法学部"),
            COMMERCE("11__12", "12", "11", "商学部"),
            MEDICINE("11__14", "14", "11", "医学部"),
            ENGINEERING("11__18", "18", "11", "理工学部"),
            GLOBAL_POLICY_AND_ENVIRONMENT("11__23", "23", "11", "総合政策・環境情報学部"),
            NURSING_AND_MEDICAL_CARE("11__26", "26", "11", "看護医療学部"),
            PHARMACY("11__28", "28", "11", "薬学部"),
            GRADUATE_SCHOOL_OF_LITERATURE("12__32", "32", "12", "[修士] 文学研究科"),
            DOCTORAL_SCHOOL_OF_LITERATURE("13__32", "32", "13", "[博士] 文学研究科"),
            GRADUATE_SCHOOL_OF_ECONOMICS("12__36", "36", "12", "[修士] 経済学研究科"),
            DOCTORAL_SCHOOL_OF_ECONOMICS("13__36", "36", "13", "[博士] 経済学研究科"),
            GRADUATE_SCHOOL_OF_LAW("12__38", "38", "12", "[修士] 法学研究科"),
            DOCTORAL_SCHOOL_OF_LAW("13__38", "38", "13", "[博士] 法学研究科"),
            GRADUATE_SCHOOL_OF_SOCIOLOGY("12__40", "40", "12", "[修士] 社会学研究科"),
            DOCTORAL_SCHOOL_OF_SOCIOLOGY("13__40", "40", "13", "[博士] 社会学研究科"),
            GRADUATE_SCHOOL_OF_BUSINESS("12__42", "42", "12", "[修士] 商学研究科"),
            DOCTORAL_SCHOOL_OF_BUSINESS("13__42", "42", "13", "[博士] 商学研究科"),
            GRADUATE_SCHOOL_OF_SCIENCE_AND_TECHNOLOGY("12__48", "48", "12", "[修士] 理工学研究科"),
            DOCTORAL_SCHOOL_OF_SCIENCE_AND_technology("13__48", "48", "13", "[博士] 理工学研究科"),
            GRADUATE_SCHOOL_OF_BUSINESS_ADMINISTRATION("12__50", "50", "12", "[修士] 経営管理研究科"),
            DOCTORAL_SCHOOL_OF_BUSINESS_ADMINISTRATION("13__50", "50", "13", "[博士] 経営管理研究科"),
            GRADUATE_SCHOOL_OF_POLICY_AND_MEDIA("12__52", "52", "12", "[修士] 政策・メディア研究科"),
            DOCTORAL_SCHOOL_OF_POLICY_AND_MEDIA("13__52", "52", "13", "[博士] 政策・メディア研究科"),
            LAW_SCHOOL("17__54", "54", "17", "法務研究科"),
            GRADUATE_SCHOOL_OF_HEALTH_MANAGEMENT("12__56", "56", "12", "[修士] 健康マネジメント研究科"),
            DOCTORAL_SCHOOL_OF_HEALTH_MANAGEMENT("13__56", "56", "13", "[博士] 健康マネジメント研究科"),
            GRADUATE_SCHOOL_OF_SYSTEM_DESIGN_AND_MANAGEMENT("12__57", "57", "12", "[修士] システムデザイン・マネジメント研究科"),
            DOCTORAL_SCHOOL_OF_SYSTEM_DESIGN_AND_management("13__57", "57", "13", "[博士] システムデザイン・マネジメント研究科"),
            GRADUATE_SCHOOL_OF_MEDIA_DESIGN("12__58", "58", "12", "[修士] メディアデザイン研究科"),
            DOCTORAL_SCHOOL_OF_MEDIA_DESIGN("13__58", "58", "13", "[博士] メディアデザイン研究科"),
            GRADUATE_SCHOOL_OF_PHARMACEUTICAL_SCIENCE("12__59", "59", "12", "[修士] 薬学研究科"),
            DOCTORAL_SCHOOL_OF_PHARMACEUTICAL_SCIENCE_1("13__59", "59", "13", "[博士] 薬学研究科（薬科学専攻）"),
            DOCTORAL_SCHOOL_OF_PHARMACEUTICAL_SCIENCE_2("14__59", "59", "14", "[博士] 薬学研究科（薬学専攻）"),
            GRADUATE_SCHOOL_COMMON("12__64", "64", "12", "[修士] 大学院共通"),
            DOCTORAL_SCHOOL_COMMON("13__64", "64", "13", "[博士] 大学院共通"),
            INSTITUTE_OF_LINGUISTICS_AND_CULTURAL_STUDIES("11__65", "65", "11", "言語文化研究所"),
            INSTITUTE_OF_MEDIA_AND_COMMUNICATION("11__66", "66", "11", "メディア・コミュニケーション研究所"),
            SHIDO_BUNKO("11__67", "67", "11", "斯道文庫"),
            INSTITUTE_OF_PHYSICAL_EDUCATION("11__69", "69", "11", "体育研究所"),
            FUKUZAWA_RESEARCH_CENTER("11__71", "71", "11", "福澤研究センター"),
            GRADUATE_SCHOOL_OF_FUKUZAWA_RESEARCH_CENTER("12__71", "71", "12", "[修士] 福澤研究センター"),
            INTERNATIONAL_CENTER("11__83", "83", "11", "国際センター"),
            GRADUATE_SCHOOL_OF_INTERNATIONAL_CENTER("12__83", "83", "12", "[修士] 国際センター"),
            HEALTH_SERVICE_CENTER("11__84", "84", "11", "保健管理センター"),
            TEACHER_TRAINING_CENTER("11__86", "86", "11", "教職課程センター"),
            JAPANESE_LANGUAGE_AND_CULTURE_EDUCATION_CENTER("11__88", "88", "11", "日本語・日本文化教育センター"),
            ART_CENTER("11__89", "89", "11", "アート・センター"),
            GRADUATE_SCHOOL_OF_ART_CENTER("12__89", "89", "12", "[修士] アート・センター"),
            CENTER_FOR_FOREIGN_LANGUAGE_EDUCATION_AND_RESEARCH("11__94", "94", "11", "外国語教育研究センター"),
            LIBERAL_ARTS_RESEARCH_CENTER("11__95", "95", "11", "教養研究センター"),
            GIC_CENTER("11__K1", "K1", "11", "GICセンター"),
            STUDENT_COMPREHENSIVE_CENTER("11__K2", "K2", "11", "学生総合センター"),
            GLOBAL_RESEARCH_INSTITUTE("11__K3", "K3", "11", "グローバルリサーチインスティテュート"),
            MUSEUM_COMMONS("11__K5", "K5", "11", "ミュージアム・コモンズ")
        }

        enum class DayOfWeek(val id: String) {
            MONDAY("1"),
            TUESDAY("2"),
            WEDNESDAY("3"),
            THURSDAY("4"),
            FRIDAY("5"),
            SATURDAY("6"),
            SUNDAY("7"),
        }

        enum class Period(val id: String) {
            ONE("1"),
            TWO("2"),
            THREE("3"),
            FOUR("4"),
            FIVE("5"),
            SIX("6"),
            SEVEN("7"),
            OTHER("9"),
        }

        enum class LessonType(val id: String) {
            IN_PERSON("1"),
            ONLINE_REALTIME("2"),
            ONLINE_NON_REALTIME("3"),
            ONLINE_ON_DEMAND("4"),
        }

        enum class LessonLanguage(val id: String) {
            ALL("ALL"),
            JAPANESE("1"),
            ENGLISH("2"),
            OTHER("9"),
        }

        enum class Field(
            val jp: String,
            val en: String,
        ) {
            All("", ""),
            GENERAL_EDUCATION("総合教育科目", "GENERAL EDUCATION"),
            FOREIGN_LANGUAGE("外国語科目", "FOREIGN LANGUAGE"),
            BASIC_EDUCATION_FOR_MAJOR("基礎教育科目", "BASIC EDUCATION FOR MAJOR"),
            SPECIALIZED_SUBJECT("専門科目", "SPECIALIZED SUBJECT"),
        }
    }

    data class SyllabusSearchDepartmentParams(
        val year: Int,
        val faculty: String,
    )

    data class SyllabusSearchFieldParams(
        val year: Int,
        val faculty: String,
        val keyword: String,
    )
}

/*val departments = lmsRepository.getDepartments(
    SyllabusApi.SyllabusSearchDepartmentParams(
        year = 2024,
        faculty = "11__18"
    )
)

val fields = lmsRepository.getFields(
    SyllabusApi.SyllabusSearchFieldParams(
        year = 2024,
        faculty = "11__18",
        keyword = "総合教育科目"
    )
)

val syllabusItems = lmsRepository.getSyllabus(
    SyllabusApi.SyllabusSearchParams(
        year = 2024,
        faculty = SyllabusApi.SyllabusSearchParams.Faculty.ENGINEERING,
        department = departments.changeTarget.departmentItems.take(3),
        keyword = "応用確率",
        field1 = SyllabusApi.SyllabusSearchParams.Field.SPECIALIZED_SUBJECT,
    )
)

Logger.d("departments: $departments")
Logger.d("fields: $fields")
Logger.d("syllabusItems: $syllabusItems")*/
