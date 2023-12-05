package caios.android.klms

import android.app.Application
import android.content.Intent
import android.os.Build
import caios.android.klms.core.common.KlmsConfig
import caios.android.klms.core.common.KlmsDebugTree
import caios.android.klms.feature.report.CrashReportActivity
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.disk.DiskCache
import coil.memory.MemoryCache
import com.google.android.material.color.DynamicColors
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class KlmsApplication : Application() {

    @Inject
    lateinit var klmsConfig: KlmsConfig

    override fun onCreate() {
        super.onCreate()

        Timber.plant(KlmsDebugTree())

        DynamicColors.applyToActivitiesIfAvailable(this)

        Thread.setDefaultUncaughtExceptionHandler { _, e ->
            startCrushReportActivity(e)
        }

        setupCoil()

        setupFirebase()
    }

    private fun startCrushReportActivity(e: Throwable) {
        Timber.e(e)

        startActivity(
            Intent(this, CrashReportActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra("report", getVersionReport() + "\n" + e.stackTraceToString())
            },
        )
    }

    private fun getVersionReport() = buildString {
        val release = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) Build.VERSION.RELEASE_OR_CODENAME else Build.VERSION.RELEASE

        appendLine("Version: ${klmsConfig.versionName} (${klmsConfig.versionCode})")
        appendLine("Device Information: $release (${Build.VERSION.SDK_INT})")
        appendLine("Device Model: ${Build.MODEL} (${Build.MANUFACTURER})")
        appendLine("Supported ABIs: ${Build.SUPPORTED_ABIS.contentToString()}")
    }

    private fun setupCoil() {
        val imageLoader = ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(this.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.02)
                    .build()
            }
            .components {
                if (Build.VERSION.SDK_INT >= 28) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .respectCacheHeaders(false)
            .crossfade(true)
            .build()

        Coil.setImageLoader(imageLoader)
    }

    private fun setupFirebase() {
        val builder = FirebaseOptions.Builder()
            .setProjectId("k-lms-a81a3")
            .setApplicationId("1:289419640315:android:2bf75e905dc81152279f5e")
            .setApiKey("AIzaSyAntQQZyYQbdiwNpgcKAsbCUnT3dOxG8II")
            .setDatabaseUrl("https://k-lms-a81a3.firebaseio.com")
            .setStorageBucket("k-lms-a81a3.appspot.com")

        FirebaseApp.initializeApp(this, builder.build())
    }
}
