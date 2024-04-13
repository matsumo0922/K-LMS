package me.matsumo.klms.core.repository

import me.matsumo.klms.core.repository.api.ApiClient
import me.matsumo.klms.core.repository.api.UserApi

class LmsRepository(
    private val client: ApiClient,
) {
    private val userApi = UserApi(client)

    // UserApi
    suspend fun getSelf() = userApi.getSelf()
    suspend fun getSelfAccount() = userApi.getSelfAccount()
    suspend fun getUser(userId: String) = userApi.getUser(userId)
    suspend fun getUserAccount(userId: String) = userApi.getUserAccount(userId)

    companion object {
        private const val PAGE_LIMIT = 10
    }
}
