package me.matsumo.klms.core.repository.api

import co.touchlab.kermit.Logger
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.CoroutineDispatcher

class CoursesApi(
    private val client: ApiClient,
    private val ioDispatcher: CoroutineDispatcher,
) {

    suspend fun getCourse() {
        client.get("courses").bodyAsText().also {
            Logger.d { it }
        }
    }
}
