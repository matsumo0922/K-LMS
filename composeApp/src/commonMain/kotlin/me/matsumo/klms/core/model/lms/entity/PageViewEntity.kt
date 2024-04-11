package me.matsumo.klms.core.model.lms.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PageViewEntity(
    // The unique ID for the page view
    @SerialName("id")
    val id: String,

    // The name of the app if the request is from an API
    @SerialName("app_name")
    val appName: String?,

    //  The requested URL
    @SerialName("url")
    val url: String,

    // The type of context for the request
    @SerialName("context_type")
    val contextType: String,

    // The type of asset in the context, if any
    @SerialName("asset_type")
    val assetType: String?,

    // Rails controller that handled the request
    @SerialName("controller")
    val controller: String,

    // Rails action that handled the request
    @SerialName("action")
    val action: String,

    // (Deprecated) This field will always be false
    @SerialName("contributed")
    val contributed: Boolean,

    // Time spent on the page in seconds (approximation)
    @SerialName("interaction_seconds")
    val interactionSeconds: Double,

    // Request timestamp
    @SerialName("created_at")
    val createdAt: String,

    // Indicates if the request was user-initiated
    @SerialName("user_request")
    val userRequest: Boolean,

    //  Time taken to render the response in seconds
    @SerialName("render_time")
    val renderTime: Double,

    // User-agent of the requesting browser/program/app
    @SerialName("user_agent")
    val userAgent: String,

    // True if the request involved participation
    @SerialName("participated")
    val participated: Boolean,

    //  The HTTP method for the request
    @SerialName("http_method")
    val httpMethod: String,

    // The origin IP address of the request
    @SerialName("remote_ip")
    val remoteIp: String,

    // Links defining relationships
    @SerialName("links")
    val links: me.matsumo.klms.core.model.lms.entity.PageViewLinksEntity
)
