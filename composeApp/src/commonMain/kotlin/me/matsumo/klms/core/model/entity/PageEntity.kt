package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageEntity(
    // The ID of the page
    @SerialName("page_id")
    val pageId: Int,

    // The unique locator for the page
    @SerialName("url")
    val url: String,

    // The title of the page
    @SerialName("title")
    val title: String,

    // The creation date for the page
    @SerialName("created_at")
    val createdAt: String,

    // The last updated date
    @SerialName("updated_at")
    val updatedAt: String,

    // (DEPRECATED) Hidden from students
    @SerialName("hide_from_students")
    val hideFromStudents: Boolean,

    // Roles allowed to edit the page
    @SerialName("editing_roles")
    val editingRoles: String,

    // The User who last edited the page
    @SerialName("last_edited_by")
    val lastEditedBy: UserEntity?, // You'll likely have a 'User' data class

    // The page content (HTML)
    @SerialName("body")
    val body: String?,

    // Whether the page is published
    @SerialName("published")
    val published: Boolean,

    // The scheduled publication date
    @SerialName("publish_at")
    val publishAt: String?,

    // Whether this page is the front page
    @SerialName("front_page")
    val frontPage: Boolean,

    // Whether this page is locked for the user
    @SerialName("locked_for_user")
    val lockedForUser: Boolean,

    // Information about the lock
    @SerialName("lock_info")
    val lockInfo: LockInfoEntity?,

    // Explanation of why this is locked for the user
    @SerialName("lock_explanation")
    val lockExplanation: String?
)
