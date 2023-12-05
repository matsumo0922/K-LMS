plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.secret.gradlePlugin)
    implementation(libs.detekt.gradlePlugin)
    implementation(libs.gms.services)
    implementation(libs.gms.oss)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "klms.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "klms.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "klms.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "klms.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibraryGlance") {
            id = "klms.library.glance"
            implementationClass = "AndroidLibraryGlanceConventionPlugin"
        }
        register("androidLibraryChaquopy") {
            id = "klms.library.chaquopy"
            implementationClass = "AndroidLibraryChaquopyConventionPlugin"
        }
        register("androidHilt") {
            id = "klms.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidDetekt") {
            id = "klms.detekt"
            implementationClass = "AndroidDetektConventionPlugin"
        }
        register("androidFirebase") {
            id = "klms.firebase"
            implementationClass = "AndroidFirebaseConventionPlugin"
        }
    }
}
