package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscussionTopicEntity(
    // The ID of this topic.
    @SerialName("id")
    val id: Int,

    // The topic title.
    @SerialName("title")
    val title: String,

    // The HTML content of the message body.
    @SerialName("message")
    val message: String,

    // The URL to the discussion topic in canvas.
    @SerialName("html_url")
    val htmlUrl: String,

    // The datetime the topic was posted ...
    @SerialName("posted_at")
    val postedAt: String,

    // The datetime for when the last reply was ...
    @SerialName("last_reply_at")
    val lastReplyAt: String,

    // If true then a user may not respond to other replies ...
    @SerialName("require_initial_post")
    val requireInitialPost: Boolean,

    // Whether or not posts in this topic are visible to the user.
    @SerialName("user_can_see_posts")
    val userCanSeePosts: Boolean,

    // The count of entries in the topic.
    @SerialName("discussion_subentry_count")
    val discussionSubentryCount: Int,

    // The read_state of the topic for the current user ...
    @SerialName("read_state")
    val readState: String,

    // The count of unread entries of this topic for the current user.
    @SerialName("unread_count")
    val unreadCount: Int,

    // Whether or not the current user is subscribed to this topic.
    @SerialName("subscribed")
    val subscribed: Boolean,

    // (Optional) Why the user cannot subscribe to this topic ...
    @SerialName("subscription_hold")
    val subscriptionHold: String? = null,

    // The unique identifier of the assignment if the topic ...
    @SerialName("assignment_id")
    val assignmentId: Int? = null,

    // The datetime to publish the topic (if not right away).
    @SerialName("delayed_post_at")
    val delayedPostAt: String? = null,

    // Whether this discussion topic is published ...
    @SerialName("published")
    val published: Boolean,

    // The datetime to lock the topic (if ever).
    @SerialName("lock_at")
    val lockAt: String? = null,

    // Whether or not the discussion is 'closed for comments'.
    @SerialName("locked")
    val locked: Boolean,

    // Whether or not the discussion has been 'pinned' ...
    @SerialName("pinned")
    val pinned: Boolean,

    // Whether or not this is locked for the user.
    @SerialName("locked_for_user")
    val lockedForUser: Boolean,

    // (Optional) Information for the user about the lock ...
    @SerialName("lock_info")
    val lockInfo: me.matsumo.klms.core.model.lms.entity.LockInfoEntity? = null, // Placeholder type - needs more structure

    // (Optional) An explanation of why this is locked for the user ...
    @SerialName("lock_explanation")
    val lockExplanation: String? = null,

    // The username of the topic creator.
    @SerialName("user_name")
    val userName: String,

    // DEPRECATED An array of topic_ids for the group discussions ...
    @SerialName("topic_children")
    val topicChildren: List<Int>,

    // An array of group discussions the user is a part of ...
    @SerialName("group_topic_children")
    val groupTopicChildren: List<me.matsumo.klms.core.model.lms.entity.DiscussionTopicEntity.GroupTopicChild>,

    // If the topic is for grading and a group assignment ...
    @SerialName("root_topic_id")
    val rootTopicId: Int? = null,

    // If the topic is a podcast topic ...
    @SerialName("podcast_url")
    val podcastUrl: String? = null,

    // The type of discussion. Values are ...
    @SerialName("discussion_type")
    val discussionType: String,

    // The unique identifier of the group category ...
    @SerialName("group_category_id")
    val groupCategoryId: Int? = null,

    // Array of file attachments.
    @SerialName("attachments")
    val attachments: List<me.matsumo.klms.core.model.lms.entity.FileAttachmentEntity>? = null,

    // The current user's permissions on this topic.
    @SerialName("permissions")
    val permissions: me.matsumo.klms.core.model.lms.entity.DiscussionTopicEntity.Permissions,

    // Whether or not users can rate entries in this topic.
    @SerialName("allow_rating")
    val allowRating: Boolean,

    // Whether or not grade permissions are required to rate entries.
    @SerialName("only_graders_can_rate")
    val onlyGradersCanRate: Boolean,

    // Whether or not entries should be sorted by rating.
    @SerialName("sort_by_rating")
    val sortByRating: Boolean
) {

    @Serializable
    data class GroupTopicChild(
        @SerialName("id")
        val id: Int,

        @SerialName("group_id")
        val groupId: Int
    )

    @Serializable
    data class Permissions(
        @SerialName("attach")
        val attach: Boolean
    )
}
