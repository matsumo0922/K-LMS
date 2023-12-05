plugins {
    id("klms.library")
    id("klms.library.compose")
    id("klms.hilt")
    id("klms.detekt")
    id("klms.firebase")
}

android {
    namespace = "caios.android.klms.core.ui"
}

dependencies {
    implementation(project(":core:model"))
    implementation(project(":core:common"))
    implementation(project(":core:repository"))
    implementation(project(":core:datastore"))

    implementation(libs.bundles.ui.implementation)

    implementation(libs.androidx.biomtrics)
    implementation(libs.androidx.biomtrics.ktx)
    implementation(libs.androidx.palette)
    implementation(libs.collapsing.toolbar.compose)
    implementation(libs.reorderble.compose)
}
