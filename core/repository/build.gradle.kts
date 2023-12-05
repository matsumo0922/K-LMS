plugins {
    id("klms.library")
    id("klms.detekt")
    id("klms.hilt")
    id("klms.firebase")
}

android {
    namespace = "caios.android.klms.core.repository"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
    implementation(project(":core:datastore"))

    implementation(libs.bundles.ktor)
    implementation(libs.jsoup)
    implementation(libs.unifile)
}
