package primitive

import me.matsumo.klms.android
import me.matsumo.klms.androidTestImplementation
import me.matsumo.klms.debugImplementation
import me.matsumo.klms.implementation
import me.matsumo.klms.library
import me.matsumo.klms.libs
import me.matsumo.klms.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class KmpAndroidCompose : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.compose")
            }

            android {
                buildFeatures.compose = true
                composeOptions.kotlinCompilerExtensionVersion = libs.version("kotlinCompiler")
            }

            dependencies {
                val bom = libs.library("androidx-compose-bom")

                implementation(project.dependencies.platform(bom))
                androidTestImplementation(project.dependencies.platform(bom))

                implementation(libs.library("androidx-compose-runtime"))
                implementation(libs.library("androidx-compose-ui"))
                implementation(libs.library("androidx-compose-ui-util"))
                implementation(libs.library("androidx-compose-ui-binding"))
                implementation(libs.library("androidx-compose-ui-tooling"))
                implementation(libs.library("androidx-compose-ui-tooling-preview"))

                debugImplementation(libs.library("androidx-compose-ui-tooling"))
            }
        }
    }
}
