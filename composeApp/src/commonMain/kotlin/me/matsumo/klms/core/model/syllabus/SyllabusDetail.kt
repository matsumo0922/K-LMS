package me.matsumo.klms.core.model.syllabus

data class SyllabusDetail(
    val year: String,
    val id: String,
    val className: String,
    val details: Map<String, String>,
    val syllabus: Pair<String, String>,
    val activeLearning: Pair<String, String>,
    val preparation: Pair<String, String>,
    val grading: Pair<String, String>,
    val textbook: Pair<String, String>,
    val reference: Pair<String, String>,
    val comment: Pair<String, String>,
    val question: Pair<String, String>,
    val contents: Pair<String, Map<String, String>>,
)
