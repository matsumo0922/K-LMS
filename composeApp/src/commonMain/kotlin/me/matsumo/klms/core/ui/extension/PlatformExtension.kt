package me.matsumo.klms.core.ui.extension

enum class Platform {
    Android,
    IOS,
}

expect val currentPlatform: Platform
