package me.matsumo.klms.core.ui.extension

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import com.eygraber.compose.placeholder.PlaceholderHighlight
import com.eygraber.compose.placeholder.material3.fade
import com.eygraber.compose.placeholder.material3.shimmer
import com.eygraber.compose.placeholder.placeholder
import com.mohamedrejeb.calf.ui.progress.AdaptiveCircularProgressIndicator

@Composable
fun SimmerPlaceHolder(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .placeholder(
                visible = true,
                color = MaterialTheme.colorScheme.surfaceVariant,
                highlight = PlaceholderHighlight.shimmer(),
                shape = RectangleShape,
            ),
    )
}

@Composable
fun FadePlaceHolder(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .placeholder(
                visible = true,
                color = MaterialTheme.colorScheme.surfaceVariant,
                highlight = PlaceholderHighlight.fade(),
                shape = RectangleShape,
            ),
    )
}

@Composable
fun IndicatorPlaceHolder(
    modifier: Modifier = Modifier,
) {
    Box(modifier.fillMaxSize()) {
        AdaptiveCircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
        )
    }
}
