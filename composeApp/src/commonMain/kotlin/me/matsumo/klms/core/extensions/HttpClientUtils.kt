package me.matsumo.klms.core.extensions

import co.touchlab.kermit.Logger
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.serialization.kotlinx.serializerForTypeInfo
import io.ktor.util.reflect.typeInfo
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import me.matsumo.klms.core.model.lms.Paging
import me.matsumo.klms.core.model.lms.getLmsPagination

@OptIn(ExperimentalSerializationApi::class)
val formatter = Json {
    isLenient = true
    prettyPrint = true
    ignoreUnknownKeys = true
    coerceInputValues = true
    encodeDefaults = true
    explicitNulls = false
}

suspend inline fun <reified T> HttpResponse.parse(
    allowRange: IntRange = 200..299,
): T? {
    val requestUrl = request.url
    val isOK = this.status.value in allowRange
    val text = this.bodyAsText()

    Logger.d("[${if (isOK) "SUCCESS" else "FAILED"}] Ktor Request: $requestUrl")
    Logger.d("[RESPONSE] ${text.replace("\n", "")}")

    return if (isOK) formatter.decodeFromString(text) else null
}

@OptIn(InternalSerializationApi::class, ExperimentalSerializationApi::class)
suspend inline fun <reified T> HttpResponse.parseList(
    allowRange: IntRange = 200..299,
    isIgnoreIllegalObject: Boolean = true,
): List<T>? {
    val requestUrl = request.url
    val isOK = this.status.value in allowRange

    Logger.d("[${if (isOK) "SUCCESS" else "FAILED"}] Ktor Request: $requestUrl")
    Logger.d("[RESPONSE] ${this.bodyAsText().replace("\n", "")}")

    if (!isOK) return null

    val serializer = formatter.serializersModule.serializerForTypeInfo(typeInfo<T>())
    val result = this.body<JsonArray>().map { runCatching { formatter.decodeFromJsonElement(serializer, it) as T } }

    return if (isIgnoreIllegalObject) result.mapNotNull { it.getOrNull() } else result.map { it.getOrThrow() }
}

fun HttpResponse.isSuccess(allowRange: IntRange = 200..299): Boolean {
    return (this.status.value in allowRange)
}

fun HttpResponse.requireSuccess(allowRange: IntRange = 200..299): HttpResponse {
    if (!isSuccess(allowRange)) error("Request failed: ${this.status.value}")
    return this
}

suspend fun <T> HttpResponse.parsePaging(
    translate: suspend (HttpResponse) -> T,
): Paging<T> {
    val pagination = headers.getLmsPagination()

    return Paging(
        data = translate.invoke(this),
        pagination = pagination,
    )
}
