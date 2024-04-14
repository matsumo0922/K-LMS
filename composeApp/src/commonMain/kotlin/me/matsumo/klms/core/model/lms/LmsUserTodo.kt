package me.matsumo.klms.core.model.lms

import me.matsumo.klms.core.model.lms.entity.LmsUserTodoEntity

data class LmsUserTodo(
    val contextType: String,
    val courseId: Int,
    val groupId: Int,
    val htmlUrl: String,
    val ignore: String,
    val ignorePermanently: String,
    val needsGradingCount: Int,
    val assignment: Assignment,
)

fun LmsUserTodoEntity.translate(): LmsUserTodo {
    return LmsUserTodo(
        contextType = contextType,
        courseId = courseId,
        groupId = groupId,
        htmlUrl = htmlUrl,
        ignore = ignore,
        ignorePermanently = ignorePermanently,
        needsGradingCount = needsGradingCount,
        assignment = assignment.translate(),
    )
}
