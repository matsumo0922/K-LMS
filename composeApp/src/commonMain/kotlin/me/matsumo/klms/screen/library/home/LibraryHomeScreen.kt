package me.matsumo.klms.screen.library.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import me.matsumo.klms.core.extensions.koinViewModel
import me.matsumo.klms.core.model.ScreenState
import me.matsumo.klms.core.model.UserData
import me.matsumo.klms.core.model.lms.DashboardCard
import me.matsumo.klms.core.ui.AsyncLoadContents
import me.matsumo.klms.core.ui.LazyPagingItemsLoadContents
import me.matsumo.klms.screen.library.home.components.LibraryHomeIdleSection
import me.matsumo.klms.screen.library.home.components.LibraryHomeTopBar

@Composable
fun LibraryHomeRoute(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LibraryHomeViewModel = koinViewModel(LibraryHomeViewModel::class),
) {
    val screenState by viewModel.screenState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        if (screenState !is ScreenState.Idle) {
            viewModel.fetch()
        }
    }

    AsyncLoadContents(
        modifier = modifier,
        screenState = screenState,
        retryAction = { viewModel.fetch() },
    ) {
        val dashboardCardsPager = it.dashboardCardsPaging.collectAsLazyPagingItems()

        LibraryHomeScreen(
            modifier = Modifier.fillMaxSize(),
            userData = it.userData,
            dashboardCardsPager = dashboardCardsPager,
            onClickDrawer = openDrawer,
            onClickCourse = {},
            onClickAnnouncement = {},
            onClickDiscussion = {},
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LibraryHomeScreen(
    userData: UserData,
    dashboardCardsPager: LazyPagingItems<DashboardCard>,
    onClickDrawer: () -> Unit,
    onClickCourse: (String) -> Unit,
    onClickAnnouncement: (String) -> Unit,
    onClickDiscussion: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(snapAnimationSpec = null, flingAnimationSpec = null)

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LibraryHomeTopBar(
                modifier = Modifier.fillMaxWidth(),
                onClickDrawer = onClickDrawer,
                scrollBehavior = scrollBehavior,
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) {
        LazyPagingItemsLoadContents(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            lazyPagingItems = dashboardCardsPager,
        ) {
            LibraryHomeIdleSection(
                modifier = Modifier.fillMaxSize(),
                pagingAdapter = dashboardCardsPager,
                onClickCourse = onClickCourse,
                onClickAnnouncement = onClickAnnouncement,
                onClickDiscussion = onClickDiscussion,
            )
        }
    }
}
