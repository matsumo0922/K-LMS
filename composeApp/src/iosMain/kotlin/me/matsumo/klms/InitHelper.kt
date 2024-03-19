package me.matsumo.klms

import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.annotation.DelicateCoilApi
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.request.crossfade
import kotlinx.cinterop.ExperimentalForeignApi
import me.matsumo.klms.di.applyModules
import okio.Path.Companion.toPath
import org.koin.core.context.startKoin
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSSearchPathForDirectoriesInDomains
import platform.Foundation.NSUserDomainMask

fun initKoin() {
    startKoin {
        applyModules()
    }
}

@OptIn(ExperimentalForeignApi::class)
fun initCoil() {
    val fileManager = NSFileManager.defaultManager

    val cacheDir = NSSearchPathForDirectoriesInDomains(
        directory = NSCachesDirectory,
        domainMask = NSUserDomainMask,
        expandTilde = true,
    )

    val imageCacheDir = cacheDir.first().toString() + "/image_cache"

    if (!fileManager.fileExistsAtPath(imageCacheDir)) {
        fileManager.createDirectoryAtPath(imageCacheDir, withIntermediateDirectories = true, attributes = null, error = null)
    }

    SingletonImageLoader.setSafe {
        ImageLoader.Builder(it)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(it, 0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(imageCacheDir.toPath())
                    .maxSizePercent(0.02)
                    .build()
            }
            .crossfade(true)
            .build()
    }
}
