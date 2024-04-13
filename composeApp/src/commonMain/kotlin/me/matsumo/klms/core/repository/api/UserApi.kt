package me.matsumo.klms.core.repository.api

import me.matsumo.klms.core.extensions.parse
import me.matsumo.klms.core.model.lms.LmsAccount
import me.matsumo.klms.core.model.lms.LmsUser
import me.matsumo.klms.core.model.lms.entity.AccountEntity
import me.matsumo.klms.core.model.lms.entity.UserEntity
import me.matsumo.klms.core.model.lms.translate

class UserApi(
    private val client: ApiClient,
) {
    suspend fun getSelf(): LmsUser {
        return client.get("users/self/profile").parse<UserEntity>()!!.translate()
    }

    suspend fun getSelfAccount(): LmsAccount {
        return client.get("accounts/self").parse<AccountEntity>()!!.translate()
    }

    suspend fun getUser(userId: String): LmsUser {
        return client.get("users/$userId/profile").parse<UserEntity>()!!.translate()
    }

    suspend fun getUserAccount(userId: String): LmsAccount {
        return client.get("accounts/$userId").parse<AccountEntity>()!!.translate()
    }
}
