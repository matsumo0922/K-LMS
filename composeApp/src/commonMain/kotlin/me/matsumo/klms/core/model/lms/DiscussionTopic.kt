package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.DiscussionTopicEntity

@Serializable
data class DiscussionTopic(
    val id: Int,
    val title: String,
    val message: String,
    val htmlUrl: String,
    val postedAt: String,
    val lastReplyAt: String,
    val requireInitialPost: Boolean,
    val userCanSeePosts: Boolean,
    val discussionSubentryCount: Int,
    val readState: String,
    val unreadCount: Int,
    val subscribed: Boolean,
    val subscriptionHold: String? = null,
    val assignmentId: Int? = null,
    val delayedPostAt: String? = null,
    val published: Boolean,
    val lockAt: String? = null,
    val locked: Boolean,
    val pinned: Boolean,
    val lockedForUser: Boolean,
    val lockInfo: LockInfo? = null,
    val lockExplanation: String? = null,
    val userName: String,
    val topicChildren: List<Int>,
    val groupTopicChildren: List<GroupTopicChild>,
    val rootTopicId: Int? = null,
    val podcastUrl: String? = null,
    val discussionType: String,
    val groupCategoryId: Int? = null,
    val attachments: List<FileAttachment>? = null,
    val permissions: Permissions,
    val allowRating: Boolean,
    val onlyGradersCanRate: Boolean,
    val sortByRating: Boolean,
) {

    @Serializable
    data class GroupTopicChild(
        val id: Int,
        val groupId: Int,
    )

    @Serializable
    data class Permissions(
        val attach: Boolean,
    )
}

fun DiscussionTopicEntity.translate(): DiscussionTopic {
    return DiscussionTopic(
        id = id,
        title = title,
        message = message,
        htmlUrl = htmlUrl,
        postedAt = postedAt,
        lastReplyAt = lastReplyAt,
        requireInitialPost = requireInitialPost,
        userCanSeePosts = userCanSeePosts,
        discussionSubentryCount = discussionSubentryCount,
        readState = readState,
        unreadCount = unreadCount,
        subscribed = subscribed,
        subscriptionHold = subscriptionHold,
        assignmentId = assignmentId,
        delayedPostAt = delayedPostAt,
        published = published,
        lockAt = lockAt,
        locked = locked,
        pinned = pinned,
        lockedForUser = lockedForUser,
        lockInfo = lockInfo?.translate(),
        lockExplanation = lockExplanation,
        userName = userName,
        topicChildren = topicChildren,
        groupTopicChildren = groupTopicChildren.map {
            DiscussionTopic.GroupTopicChild(
                id = it.id,
                groupId = it.groupId,
            )
        },
        rootTopicId = rootTopicId,
        podcastUrl = podcastUrl,
        discussionType = discussionType,
        groupCategoryId = groupCategoryId,
        attachments = attachments?.map { it.translate() },
        permissions = DiscussionTopic.Permissions(
            attach = permissions.attach,
        ),
        allowRating = allowRating,
        onlyGradersCanRate = onlyGradersCanRate,
        sortByRating = sortByRating,
    )
}
