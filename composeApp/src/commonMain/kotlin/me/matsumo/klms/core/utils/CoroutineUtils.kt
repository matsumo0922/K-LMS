package me.matsumo.klms.core.utils

import co.touchlab.kermit.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException

suspend fun <T> suspendRunCatching(block: suspend () -> T): Result<T> = try {
    Result.success(block())
} catch (cancellationException: CancellationException) {
    throw cancellationException
} catch (exception: Exception) {
    Logger.i(exception) { "Failed to evaluate a suspendRunCatchingBlock. Returning failure Result" }
    Result.failure(exception)
}

open class MainScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = (Dispatchers.Main + SupervisorJob())
}

open class IOScope : CoroutineScope {
    override val coroutineContext: CoroutineContext = (Dispatchers.IO + SupervisorJob())
}
