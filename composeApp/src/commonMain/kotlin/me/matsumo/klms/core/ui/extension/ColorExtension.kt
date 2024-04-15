package me.matsumo.klms.core.ui.extension

import androidx.compose.ui.graphics.Color
import kotlin.math.absoluteValue

fun Color.Companion.getColor(seed: Any): Color {
    val hash = seed.hashCode().absoluteValue
    val hue = hash % 360f // 色相は0から360度の間
    val saturation = 0.5f + (hash % 50) / 100f // 彩度は0.5から0.99の間に調整
    val brightness = 0.3f + (hash % 50) / 100f // 明度は0.3から0.79の間に調整

    return hsv(hue, saturation, brightness)
}
