package me.matsumo.klms.core.model.lms


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DashboardCardEntity(
    @SerialName("assetString")
    val assetString: String,
    @SerialName("canChangeCoursePublishState")
    val canChangeCoursePublishState: Boolean,
    @SerialName("canManage")
    val canManage: Boolean,
    @SerialName("canReadAnnouncements")
    val canReadAnnouncements: Boolean,
    @SerialName("color")
    val color: String?,
    @SerialName("courseCode")
    val courseCode: String,
    @SerialName("defaultView")
    val defaultView: String,
    @SerialName("enrollmentState")
    val enrollmentState: String,
    @SerialName("enrollmentType")
    val enrollmentType: String,
    @SerialName("href")
    val href: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String?,
    @SerialName("isFavorited")
    val isFavorited: Boolean,
    @SerialName("isHomeroom")
    val isHomeroom: Boolean,
    @SerialName("isK5Subject")
    val isK5Subject: Boolean,
    @SerialName("links")
    val links: List<Link>,
    @SerialName("longName")
    val longName: String,
    @SerialName("originalName")
    val originalName: String,
    @SerialName("pagesUrl")
    val pagesUrl: String,
    @SerialName("position")
    val position: Int?,
    @SerialName("published")
    val published: Boolean,
    @SerialName("shortName")
    val shortName: String,
    @SerialName("subtitle")
    val subtitle: String,
    @SerialName("term")
    val term: String,
    @SerialName("useClassicFont")
    val useClassicFont: Boolean
) {
    @Serializable
    data class Link(
        @SerialName("css_class")
        val cssClass: String,
        @SerialName("icon")
        val icon: String,
        @SerialName("label")
        val label: String,
        @SerialName("path")
        val path: String
    )
}
