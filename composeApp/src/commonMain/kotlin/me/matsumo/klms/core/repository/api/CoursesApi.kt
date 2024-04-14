package me.matsumo.klms.core.repository.api

import androidx.paging.PagingData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import me.matsumo.klms.core.extensions.parse
import me.matsumo.klms.core.extensions.parseList
import me.matsumo.klms.core.model.lms.Course
import me.matsumo.klms.core.model.lms.CourseProgress
import me.matsumo.klms.core.model.lms.DashboardCard
import me.matsumo.klms.core.model.lms.DashboardCardEntity
import me.matsumo.klms.core.model.lms.entity.CourseEntity
import me.matsumo.klms.core.model.lms.entity.CourseProgressEntity
import me.matsumo.klms.core.model.lms.translate
import me.matsumo.klms.core.repository.paging.getPagingDataFlow

class CoursesApi(
    private val client: ApiClient,
    private val scope: CoroutineScope,
) {
    suspend fun getCourse(courseId: String): Course {
        return client.get("courses/$courseId", courseParams).parse<CourseEntity>()!!.translate()
    }

    suspend fun getCourses(): Flow<PagingData<Course>> {
        return client.getPagingDataFlow(
            dir = "courses",
            params = courseParams,
            cachedInScope = scope,
            translate = { response ->
                response.parseList<CourseEntity>()!!.map { it.translate() }
            }
        )
    }

    suspend fun getCourseProgress(courseId: String): CourseProgress {
        return client.get("courses/$courseId/users/self/progress").parse<CourseProgressEntity>()!!.translate()
    }

    suspend fun getDashboardCards(): Flow<PagingData<DashboardCard>> {
        return client.getPagingDataFlow(
            dir = "dashboard/dashboard_cards",
            cachedInScope = scope,
            translate = { response ->
                response.parseList<DashboardCardEntity>()!!.map { it.translate() }
            }
        )
    }

    private val courseParams = listOf(
        "include[]" to "term",
        "include[]" to "total_scores",
        "include[]" to "license",
        "include[]" to "is_public",
        "include[]" to "needs_grading_count",
        "include[]" to "permissions",
        "include[]" to "favorites",
        "include[]" to "current_grading_period_scores",
        "include[]" to "course_image",
        "include[]" to "banner_image",
        "include[]" to "sections",
        "include[]" to "settings",
        "state[]" to "completed",
        "state[]" to "available"
    )
}
