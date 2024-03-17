package primitive

import me.matsumo.klms.androidApplication
import me.matsumo.klms.bundle
import me.matsumo.klms.implementation
import me.matsumo.klms.library
import me.matsumo.klms.libs
import me.matsumo.klms.setupAndroid
import me.matsumo.klms.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpAndroidApplication : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("kotlin-parcelize")
                apply("kotlinx-serialization")
                apply("project-report")
                apply("com.google.firebase.crashlytics")
                apply("com.google.devtools.ksp")
                apply("com.google.gms.google-services")
                apply("com.mikepenz.aboutlibraries.plugin")
                apply("com.codingfeline.buildkonfig")
            }

            androidApplication {
                setupAndroid()

                compileSdk = libs.version("compileSdk").toInt()
                defaultConfig.targetSdk = libs.version("targetSdk").toInt()
                buildFeatures.viewBinding = true

                defaultConfig {
                    applicationId = "me.matsumo.klms"

                    versionName = libs.version("versionName")
                    versionCode = libs.version("versionCode").toInt()
                }

                packaging {
                    resources.excludes.addAll(
                        listOf(
                            "LICENSE",
                            "LICENSE.txt",
                            "NOTICE",
                            "asm-license.txt",
                            "cglib-license.txt",
                            "mozilla/public-suffix-list.txt",
                        )
                    )
                }
            }

            dependencies {
                val bom = libs.library("firebase-bom")

                implementation(platform(bom))
                implementation(libs.bundle("firebase"))
            }
        }
    }
}
