package me.matsumo.klms.core.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemProperties(
    val sampleNum: Int? = null
)

fun ItemPropertiesEntity.translate(): ItemProperties {
    return ItemProperties(
        
    )
}
