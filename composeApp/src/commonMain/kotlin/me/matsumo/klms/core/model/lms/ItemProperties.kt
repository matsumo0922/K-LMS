package me.matsumo.klms.core.model.lms

import kotlinx.serialization.Serializable
import me.matsumo.klms.core.model.lms.entity.ItemPropertiesEntity

@Serializable
data class ItemProperties(
    val sampleNum: Int? = null,
)

fun ItemPropertiesEntity.translate(): ItemProperties {
    return ItemProperties(
        sampleNum = sampleNum,
    )
}
