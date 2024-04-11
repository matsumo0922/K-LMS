package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.GroupCategoryEntity

@Serializable
data class GroupCategory(
        val id: Int,

        val name: String,

        val role: String? = null,

        val selfSignup: String? = null,

        val autoLeader: String? = null,

        val contextType: String,

    val accountId: Int,

        val groupLimit: Int? = null,

        val sisGroupCategoryId: String? = null,

        val sisImportId: Int? = null,

        val progress: ProgressEntity? = null
)

fun GroupCategoryEntity.translate(): GroupCategory {
    return GroupCategory(
        id = id,
        name = name,
        role = role,
        selfSignup = selfSignup,
        autoLeader = autoLeader,
        contextType = contextType,
        accountId = accountId,
        groupLimit = groupLimit,
        sisGroupCategoryId = sisGroupCategoryId,
        sisImportId = sisImportId
    )
}
