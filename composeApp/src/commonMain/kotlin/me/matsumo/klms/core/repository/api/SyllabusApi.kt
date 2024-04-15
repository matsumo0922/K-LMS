package me.matsumo.klms.core.repository.api

import kotlinx.coroutines.CoroutineScope
import me.matsumo.klms.core.extensions.parse
import me.matsumo.klms.core.model.syllabus.SyllabusDepartmentItems
import me.matsumo.klms.core.model.syllabus.SyllabusDepartmentItemsEntity
import me.matsumo.klms.core.model.syllabus.translate

class SyllabusApi(
    private val client: ApiClient,
    private val scope: CoroutineScope,
) {
    suspend fun getSyllabus() {
        client.post("https://gslbs.keio.jp/syllabus/result")
    }

    suspend fun getDepartments(params: SyllabusSearchDepartmentParams): SyllabusDepartmentItems {
        return client.post("https://gslbs.keio.jp/syllabus/search", params.toParams()).parse<SyllabusDepartmentItemsEntity>()!!.translate()
    }

    private fun SyllabusSearchDepartmentParams.toParams(): List<Pair<String, String>> {
        return listOf(
            "ACTION_ID" to "SYLLABUS_SEARCH_KEYWORD_CHANGE_ITEM",
            "CHANGE_TARGET_SRC" to "KEYWORD_PRGANDFCD",
            "KEYWORD_TTBLYR" to year.toString(),
            "KEYWORD_PRGANDFCD" to faculty,
            "KEYWORD_SCRGUTP" to "ALL",
            "KEYWORD_FLD1CD" to "ALL",
        )
    }

    data class SyllabusSearchParams(
        val year: Int,
        val semester: Semester,
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
            GIC_CENTER("11__K1", "K1", "11", "ＧＩＣセンター"),
            STUDENT_COMPREHENSIVE_CENTER("11__K2", "K2", "11", "学生総合センター"),
            GLOBAL_RESEARCH_INSTITUTE("11__K3", "K3", "11", "グローバルリサーチインスティテュート"),
            MUSEUM_COMMONS("11__K5", "K5", "11", "ミュージアム・コモンズ")
        }
    }

    data class SyllabusSearchDepartmentParams(
        val year: Int,
        val faculty: String,
    )
}
