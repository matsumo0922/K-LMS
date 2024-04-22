package me.matsumo.klms.screen.library.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.itemContentType
import app.cash.paging.compose.itemKey
import me.matsumo.klms.core.model.lms.DashboardCard
import me.matsumo.klms.core.ui.component.DashboardCardItem

@Composable
fun LibraryHomeIdleSection(
    pagingAdapter: LazyPagingItems<DashboardCard>,
    onClickCourse: (String) -> Unit,
    onClickAnnouncement: (String) -> Unit,
    onClickDiscussion: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            count = pagingAdapter.itemCount,
            key = pagingAdapter.itemKey { it.id },
            contentType = pagingAdapter.itemContentType(),
        ) { index ->
            pagingAdapter[index]?.let { dashboardCard ->
                DashboardCardItem(
                    modifier = Modifier.fillMaxHeight(),
                    dashboardCard = dashboardCard,
                    onClickCourse = onClickCourse,
                    onClickAnnouncement = onClickAnnouncement,
                    onClickDiscussion = onClickDiscussion,
                )
            }
        }
    }
}
