package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable

data class DashboardCard(
    val assetString: String,
    val canChangeCoursePublishState: Boolean,
    val canManage: Boolean,
    val canReadAnnouncements: Boolean,
    val color: String?,
    val courseCode: String,
    val defaultView: String,
    val enrollmentState: String,
    val enrollmentType: String,
    val href: String,
    val id: String,
    val image: String?,
    val isFavorited: Boolean,
    val isHomeroom: Boolean,
    val isK5Subject: Boolean,
    val links: List<Link>,
    val longName: String,
    val originalName: String,
    val pagesUrl: String,
    val position: Int?,
    val published: Boolean,
    val shortName: String,
    val subtitle: String,
    val term: String,
    val useClassicFont: Boolean
) {
    @Serializable
    data class Link(
        val cssClass: String,
        val icon: String,
        val label: String,
        val path: String
    )
}

fun DashboardCardEntity.translate(): DashboardCard {
    return DashboardCard(
        assetString = assetString,
        canChangeCoursePublishState = canChangeCoursePublishState,
        canManage = canManage,
        canReadAnnouncements = canReadAnnouncements,
        color = color,
        courseCode = courseCode,
        defaultView = defaultView,
        enrollmentState = enrollmentState,
        enrollmentType = enrollmentType,
        href = href,
        id = id.toString(),
        image = image,
        isFavorited = isFavorited,
        isHomeroom = isHomeroom,
        isK5Subject = isK5Subject,
        links = links.map {
            DashboardCard.Link(
                cssClass = it.cssClass,
                icon = it.icon,
                label = it.label,
                path = it.path
            )
        },
        longName = longName,
        originalName = originalName,
        pagesUrl = pagesUrl,
        position = position,
        published = published,
        shortName = shortName,
        subtitle = subtitle,
        term = term,
        useClassicFont = useClassicFont
    )
}
