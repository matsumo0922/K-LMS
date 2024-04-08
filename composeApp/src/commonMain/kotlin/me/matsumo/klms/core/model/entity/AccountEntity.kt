package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Account(
    // the ID of the Account object
    @SerialName("id") val id: Int,
    // The display name of the account
    @SerialName("name") val name: String,
    // The UUID of the account
    @SerialName("uuid") val uuid: String,
    // The account's parent ID, or null if this is the root account
    @SerialName("parent_account_id") val parentAccountId: Int?,
    // The ID of the root account, or null if this is the root account
    @SerialName("root_account_id") val rootAccountId: Int?,
    // The storage quota for the account in megabytes, if not otherwise specified
    @SerialName("default_storage_quota_mb") val defaultStorageQuotaMb: Int,
    // The storage quota for a user in the account in megabytes, if not otherwise specified
    @SerialName("default_user_storage_quota_mb") val defaultUserStorageQuotaMb: Int,
    // The storage quota for a group in the account in megabytes, if not otherwise specified
    @SerialName("default_group_storage_quota_mb") val defaultGroupStorageQuotaMb: Int,
    // The default time zone of the account. Allowed time zones are IANA time zones or friendlier Ruby on Rails time zones.
    @SerialName("default_time_zone") val defaultTimeZone: String,
    // The account's identifier in the Student Information System. Only included if the user has permission to view SIS information.
    @SerialName("sis_account_id") val sisAccountId: String,
    // The account's identifier in the Student Information System. Only included if the user has permission to view SIS information.
    @SerialName("integration_id") val integrationId: String,
    // The id of the SIS import if created through SIS. Only included if the user has permission to manage SIS information.
    @SerialName("sis_import_id") val sisImportId: Int?,
    // The account's identifier that is sent as context_id in LTI launches.
    @SerialName("lti_guid") val ltiGuid: String,
    // The state of the account. Can be 'active' or 'deleted'.
    @SerialName("workflow_state") val workflowState: String
)
