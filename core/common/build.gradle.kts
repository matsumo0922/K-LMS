plugins {
    id("klms.library")
    id("klms.detekt")
    id("klms.hilt")
    id("klms.firebase")
}

android {
    namespace = "caios.android.klms.core.common"
}

dependencies {
    api(libs.bundles.infra.api)
    implementation(libs.libraries.core)
}
