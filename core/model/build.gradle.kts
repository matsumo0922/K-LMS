plugins {
    id("klms.library")
    id("klms.library.compose")
    id("klms.detekt")
    id("klms.firebase")
}

android {
    namespace = "caios.android.klms.core.model"
}

dependencies {
    implementation(project(":core:common"))
}
