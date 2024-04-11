package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageRevisionEntity(
    // An identifier for this revision
    @SerialName("revision_id")
    val revisionId: Int,

    // The time when this revision was saved
    @SerialName("updated_at")
    val updatedAt: String,

    // Whether the revision is the latest
    @SerialName("latest")
    val latest: Boolean,

    // The User who saved this revision
    @SerialName("edited_by")
    val editedBy: me.matsumo.klms.core.model.lms.entity.UserEntity?, // You'll likely have a 'User' data class

    // Fields not always included
    @SerialName("url")
    val url: String?,

    @SerialName("title")
    val title: String?,

    @SerialName("body")
    val body: String?
)
