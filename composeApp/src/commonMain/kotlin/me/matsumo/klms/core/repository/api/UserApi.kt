package me.matsumo.klms.core.repository.api

import me.matsumo.klms.core.extensions.parse
import me.matsumo.klms.core.model.lms.LmsAccount
import me.matsumo.klms.core.model.lms.LmsProfile
import me.matsumo.klms.core.model.lms.LmsUser
import me.matsumo.klms.core.model.lms.LmsUserTodo
import me.matsumo.klms.core.model.lms.entity.AccountEntity
import me.matsumo.klms.core.model.lms.entity.LmsUserTodoEntity
import me.matsumo.klms.core.model.lms.entity.ProfileEntity
import me.matsumo.klms.core.model.lms.entity.UserEntity
import me.matsumo.klms.core.model.lms.translate

class UserApi(
    private val client: ApiClient,
) {
    suspend fun getSelfUser(): LmsUser {
        return client.get("users/self").parse<UserEntity>()!!.translate()
    }

    suspend fun getSelfProfile(): LmsProfile {
        return client.get("users/self/profile").parse<ProfileEntity>()!!.translate()
    }

    suspend fun getSelfAccount(): LmsAccount {
        return client.get("accounts/self").parse<AccountEntity>()!!.translate()
    }

    suspend fun getSelfTodo(): List<LmsUserTodo> {
        return client.get("users/self/todo").parse<List<LmsUserTodoEntity>>()!!.map { it.translate() }
    }

    // cannot use without admin permission
    suspend fun getUser(userId: String): LmsUser {
        return client.get("users/$userId").parse<UserEntity>()!!.translate()
    }

    // cannot use without admin permission
    suspend fun getProfile(userId: String): LmsProfile {
        return client.get("users/$userId/profile").parse<ProfileEntity>()!!.translate()
    }

    // cannot use without admin permission
    suspend fun getAccount(accountId: String): LmsAccount {
        return client.get("accounts/$accountId").parse<AccountEntity>()!!.translate()
    }
}
