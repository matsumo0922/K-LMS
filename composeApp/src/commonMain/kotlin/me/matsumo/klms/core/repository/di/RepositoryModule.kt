package me.matsumo.klms.core.repository.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import me.matsumo.klms.core.repository.CookiesRepository
import me.matsumo.klms.core.repository.UserDataRepository
import me.matsumo.klms.core.repository.UserDataRepositoryImpl
import org.koin.dsl.module


@OptIn(ExperimentalSerializationApi::class)
val repositoryModule = module {
    single {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
            explicitNulls = false
        }
    }

    single {
        HttpClient {
            install(Logging) {
                level = LogLevel.INFO
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.d(message)
                    }
                }
            }

            install(HttpCookies) {
                storage = CookiesRepository(get())
            }

            install(ContentNegotiation) {
                json(get<Json>())
            }
        }
    }

    single<UserDataRepository> {
        UserDataRepositoryImpl(
            lmsDataStore = get()
        )
    }
}
