package me.matsumo.klms.core.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import me.matsumo.klms.core.repository.api.ApiClient
import me.matsumo.klms.core.repository.api.CoursesApi
import me.matsumo.klms.core.repository.api.SyllabusApi
import me.matsumo.klms.core.repository.api.UserApi

class LmsRepository(
    private val client: ApiClient,
    private val ioDispatcher: CoroutineDispatcher,
) {
    private val scope = CoroutineScope(SupervisorJob() + ioDispatcher)

    private val syllabusApi = SyllabusApi(client)
    private val userApi = UserApi(client)
    private val coursesApi = CoursesApi(client, scope)

    // SyllabusApi
    suspend fun getSyllabus(params: SyllabusApi.SyllabusSearchParams) = syllabusApi.getSyllabus(params)
    suspend fun getDepartments(params: SyllabusApi.SyllabusSearchDepartmentParams) = syllabusApi.getDepartments(params)
    suspend fun getFields(params: SyllabusApi.SyllabusSearchFieldParams) = syllabusApi.getFields(params)

    // UserApi
    suspend fun getSelfUser() = userApi.getSelfUser()
    suspend fun getSelfProfile() = userApi.getSelfProfile()
    suspend fun getSelfAccount() = userApi.getSelfAccount()
    suspend fun getSelfTodo() = userApi.getSelfTodo()
    suspend fun getUser(userId: String) = userApi.getUser(userId)
    suspend fun getProfile(userId: String) = userApi.getProfile(userId)
    suspend fun getAccount(accountId: String) = userApi.getAccount(accountId)

    // CoursesApi
    suspend fun getCourse(courseId: String) = coursesApi.getCourse(courseId)
    suspend fun getCourses() = coursesApi.getCourses()
    suspend fun getCourseProgress(courseId: String) = coursesApi.getCourseProgress(courseId)
    suspend fun getDashboardCards() = coursesApi.getDashboardCards()

    companion object {
        private const val PAGE_LIMIT = 10
    }
}
