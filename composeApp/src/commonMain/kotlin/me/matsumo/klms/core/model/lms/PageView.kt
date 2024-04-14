package me.matsumo.klms.core.model.lms

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.PageViewEntity

@Serializable
data class PageView(
    val id: String,
    val appName: String?,
    val url: String,
    val contextType: String,
    val assetType: String?,
    val controller: String,
    val action: String,
    val contributed: Boolean,
    val interactionSeconds: Double,
    val createdAt: Instant,
    val userRequest: Boolean,
    val renderTime: Double,
    val userAgent: String,
    val participated: Boolean,
    val httpMethod: String,
    val remoteIp: String,
    val links: PageViewLinks,
)

fun PageViewEntity.translate(): PageView {
    return PageView(
        id = id,
        appName = appName,
        url = url,
        contextType = contextType,
        assetType = assetType,
        controller = controller,
        action = action,
        contributed = contributed,
        interactionSeconds = interactionSeconds,
        createdAt = Instant.parse(createdAt),
        userRequest = userRequest,
        renderTime = renderTime,
        userAgent = userAgent,
        participated = participated,
        httpMethod = httpMethod,
        remoteIp = remoteIp,
        links = links.translate(),
    )
}
