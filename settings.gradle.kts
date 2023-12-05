@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://www.jitpack.io")
        maven(url = "https://chaquo.com/maven-test")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://www.jitpack.io")
    }
}

rootProject.name = "K-LMS"
include(":app")
include(":core:ui")
include(":core:repository")
include(":core:model")
include(":core:datastore")
include(":core:common")
include(":feature:library")
include(":feature:setting")
include(":feature:welcome")
include(":feature:report")
