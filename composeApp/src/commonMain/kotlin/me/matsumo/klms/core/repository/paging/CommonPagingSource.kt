package me.matsumo.klms.core.repository.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.cachedIn
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import me.matsumo.klms.core.extensions.parsePaging
import me.matsumo.klms.core.extensions.suspendRunCatching
import me.matsumo.klms.core.model.lms.Paging
import me.matsumo.klms.core.repository.api.ApiClient

fun <T : Any> ApiClient.getPagingDataFlow(
    dir: String,
    cachedInScope: CoroutineScope,
    translate: suspend (HttpResponse) -> List<T>,
    params: List<Pair<String, String>> = emptyList(),
    pageSize: Int = ApiClient.PER_PAGE,
    pagingSourceFactory: () -> PagingSource<String, T> = {
        CommonPagingSource(
            client = this,
            dir = dir,
            parameters = params,
            translate = translate,
        )
    },
): Flow<PagingData<T>> {
    return Pager(
        config = PagingConfig(pageSize = pageSize),
        initialKey = null,
        pagingSourceFactory = pagingSourceFactory,
    )
        .flow
        .cachedIn(cachedInScope)
}

private class CommonPagingSource<T : Any>(
    private val client: ApiClient,
    private val dir: String,
    private val parameters: List<Pair<String, String>>,
    private val translate: suspend (HttpResponse) -> List<T>,
) : PagingSource<String, T>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, T> {
        return suspendRunCatching {
            if (params.key == null) {
                client.get(dir, parameters)
            } else {
                client.get(params.key!!)
            }.let {
                it.parsePaging { response ->
                    translate.invoke(response)
                }
            }
        }.fold(
            onSuccess = { page ->
                LoadResult.Page(
                    data = page.data,
                    nextKey = page.pagination.next,
                    prevKey = page.pagination.previous,
                )
            },
            onFailure = {
                LoadResult.Error(it)
            },
        )
    }

    override fun getRefreshKey(state: PagingState<String, T>): String? = null
}
