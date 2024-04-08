package me.matsumo.klms.core.repository

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineDispatcher

interface LmsRepository {


}

class LmsRepositoryImpl(
    private val client: HttpClient,
    private val ioDispatcher: CoroutineDispatcher,
): LmsRepository, NetworkRepository(client, API) {



    companion object {
        private const val API = "https://lms.keio.jp/api/v1"
        private const val PAGE_LIMIT = 10
    }
}
