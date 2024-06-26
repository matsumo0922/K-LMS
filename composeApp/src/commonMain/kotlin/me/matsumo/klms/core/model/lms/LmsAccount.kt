package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.AccountEntity

@Serializable
data class LmsAccount(
    val id: Int,
    val name: String,
    val uuid: String,
    val parentAccountId: Int?,
    val rootAccountId: Int?,
    val defaultStorageQuotaMb: Int,
    val defaultUserStorageQuotaMb: Int,
    val defaultGroupStorageQuotaMb: Int,
    val defaultTimeZone: String,
    val sisAccountId: String,
    val integrationId: String,
    val sisImportId: Int?,
    val ltiGuid: String,
    val workflowState: String,
)

fun AccountEntity.translate(): LmsAccount {
    return LmsAccount(
        id = id,
        name = name,
        uuid = uuid,
        parentAccountId = parentAccountId,
        rootAccountId = rootAccountId,
        defaultStorageQuotaMb = defaultStorageQuotaMb,
        defaultUserStorageQuotaMb = defaultUserStorageQuotaMb,
        defaultGroupStorageQuotaMb = defaultGroupStorageQuotaMb,
        defaultTimeZone = defaultTimeZone,
        sisAccountId = sisAccountId,
        integrationId = integrationId,
        sisImportId = sisImportId,
        ltiGuid = ltiGuid,
        workflowState = workflowState,
    )
}
