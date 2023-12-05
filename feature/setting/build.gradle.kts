plugins {
    id("klms.library")
    id("klms.library.compose")
    id("klms.hilt")
    id("klms.detekt")
    id("klms.firebase")
}

android {
    namespace = "caios.android.klms.feature.setting"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:repository"))
    implementation(project(":core:datastore"))
    implementation(project(":core:ui"))

    implementation(libs.bundles.ui.implementation)
    implementation(libs.libraries.ui)
}
