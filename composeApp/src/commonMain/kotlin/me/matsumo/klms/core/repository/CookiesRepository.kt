package me.matsumo.klms.core.repository

import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import io.ktor.http.parseServerSetCookieHeader
import io.ktor.http.renderCookieHeader
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import me.matsumo.klms.core.datastore.LmsCookieDataStore

class CookiesRepository(
    private val cookieDataStore: LmsCookieDataStore,
): CookiesStorage {

    private val mutex = Mutex()

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie): Unit = mutex.withLock {
        cookieDataStore.addCookies(listOf(renderCookieHeader(cookie)))
    }

    override suspend fun get(requestUrl: Url): List<Cookie> = mutex.withLock {
        cookieDataStore.getCookies().map { parseServerSetCookieHeader(it) }
    }

    override fun close() {
        /* do nothing */
    }
}
