plugins {
    id("klms.library")
    id("klms.detekt")
    id("klms.hilt")
    id("klms.firebase")
    alias(libs.plugins.protobuf)
}

android {
    namespace = "caios.android.klms.core.datastore"
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))

    implementation(libs.androidx.datastore)
    implementation(libs.protobuf.kotlin.lite)
}
