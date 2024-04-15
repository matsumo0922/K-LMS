package me.matsumo.klms.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Announcement
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Announcement
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.Forum
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import me.matsumo.klms.core.model.lms.DashboardCard
import me.matsumo.klms.core.theme.bold
import me.matsumo.klms.core.ui.extension.getColor
import org.jetbrains.compose.resources.stringResource

@Composable
fun DashboardCardItem(
    dashboardCard: DashboardCard,
    onClickCourse: (String) -> Unit,
    onClickAnnouncement: () -> Unit,
    onClickDiscussion: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClickCourse.invoke(dashboardCard.courseCode) },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp)),
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
        ) {
            DashboardImage(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.3f),
                dashboardCard = dashboardCard,
            )

            Column(
                modifier = Modifier
                    .padding(16.dp, 12.dp)
                    .height(128.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical =  8.dp)
                        .fillMaxWidth(),
                    text = dashboardCard.courseCode,
                    style = MaterialTheme.typography.titleMedium.bold(),
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = dashboardCard.term,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.weight(1f))

                DashboardButtons(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    dashboardCard = dashboardCard,
                    onClickAnnouncement = onClickAnnouncement,
                    onClickDiscussion = onClickDiscussion,
                )
            }
        }
    }
}

@Composable
private fun DashboardImage(
    dashboardCard: DashboardCard,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.background(Color.Companion.getColor(dashboardCard.longName)),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxHeight(),
            model = dashboardCard.image,
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
    }
}

@Composable
private fun DashboardButtons(
    dashboardCard: DashboardCard,
    onClickAnnouncement: () -> Unit,
    onClickDiscussion: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = onClickAnnouncement
        ) {
            Icon(
                modifier = Modifier.size(22.dp),
                imageVector = Icons.Default.Campaign,
                contentDescription = "announcement"
            )
        }

        IconButton(
            modifier = Modifier.size(32.dp),
            onClick = onClickDiscussion
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Default.Forum,
                contentDescription = "discussion"
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer),
        ) {
            Text(
                modifier = Modifier.padding(6.dp, 4.dp),
                text = "ID: ${dashboardCard.id}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
    }
}
