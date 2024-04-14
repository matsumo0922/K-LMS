package me.matsumo.klms.core.ui.extension

import androidx.compose.ui.graphics.Color

fun Color.getColor(seed: String): Color {
    val hash = seed.hashCode()
    val red = (hash and 0xFF0000) shr 16
    val green = (hash and 0x00FF00) shr 8
    val blue = hash and 0x0000FF

    // 生成されたRGB値でColorオブジェクトを作成
    return Color(red, green, blue)
}
