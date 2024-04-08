package me.matsumo.klms.core.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.forms.submitForm
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import io.ktor.util.InternalAPI
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

open class NetworkRepository(
    private val client: HttpClient,
    private val baseUrl: String = "",
) {
    suspend fun get(
        dir: String,
        base: String = baseUrl,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return get("$base/$dir", params)
    }

    suspend fun post(
        dir: String,
        base: String = baseUrl,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return post("$base/$dir", params)
    }

    suspend fun form(
        dir: String,
        base: String = baseUrl,
        params: Map<String, String> = emptyMap(),
        formParams: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return form("$base/$dir", params, formParams)
    }

    suspend fun get(
        url: String,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return client.get {
            url(url)

            for ((key, value) in params) {
                parameter(key, value)
            }
        }
    }

    @OptIn(InternalAPI::class)
    suspend fun post(
        url: String,
        params: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return client.post {
            url(url)

            body = buildJsonObject {
                for ((key, value) in params) {
                    put(key, value)
                }
            }.toString()
        }
    }

    suspend fun form(
        url: String,
        params: Map<String, String> = emptyMap(),
        formParams: Map<String, String> = emptyMap(),
    ): HttpResponse {
        return client.submitForm(
            url = url,
            formParameters = Parameters.build {
                for ((key, value) in formParams) {
                    append(key, value)
                }
            },
        ) {
            for ((key, value) in params) {
                parameter(key, value)
            }
        }
    }
}
