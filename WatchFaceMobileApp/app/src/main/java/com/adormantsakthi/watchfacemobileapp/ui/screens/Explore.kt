package com.adormantsakthi.watchfacemobileapp.ui.screens

import android.graphics.Paint.Align
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adormantsakthi.watchfacemobileapp.R

@Composable
fun Explore() {

    val screenWidth = LocalConfiguration.current.screenWidthDp

    data class LatestReleases(
        val title: String,
        val subtitle: String,
        val color: Color,
        val image: Int
    )

    val latestReleases = listOf(
        LatestReleases("Sprite", "Version 1.0.0", Color(135, 163, 125), R.drawable.watchface),
        LatestReleases("Futuristic", "Version 2.1.0", Color(200, 150, 80), R.drawable.watchface),
        LatestReleases("Minimal", "Version 3.0.0", Color(100, 150, 200), R.drawable.watchface),
        LatestReleases("Retro", "Version 3.0.0", Color(5, 150, 200), R.drawable.watchface)
    )

    val latestReleaseScrollState = rememberLazyListState()

    // Track the currently focused item (Could use for animation later on)
    var focusedIndex by remember { mutableIntStateOf(0) }

    // Detect scroll changes and update focused index
    LaunchedEffect(latestReleaseScrollState) {
        snapshotFlow { latestReleaseScrollState.firstVisibleItemIndex }
            .collect { index ->
                focusedIndex = index
                // Ensure we stop at the focused item
                latestReleaseScrollState.animateScrollToItem(index)
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Latest Release",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(20.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        LazyRow(
            state = latestReleaseScrollState,
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(screenWidth.dp * 0.05f),
            flingBehavior = rememberSnapFlingBehavior(lazyListState = latestReleaseScrollState)
        ) {
            itemsIndexed(latestReleases){index, item ->
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(screenWidth.dp * 0.85f)
                        .clip(RoundedCornerShape(40.dp))
                        .background(item.color)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = item.title,
                                style = MaterialTheme.typography.displayLarge,
                                maxLines = 1
                            )
                            Text(
                                text = item.subtitle,
                                style = MaterialTheme.typography.displayLarge.copy(fontSize = 15.sp),
                                maxLines = 1
                            )
                        }

                        Image(
                            painter = painterResource(id = item.image),
                            contentDescription = item.title,
                            modifier = Modifier.size(125.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            "All Our Releases",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(20.dp)
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = screenWidth.dp * 0.05f)
        ) {
            latestReleases.chunked(2).forEach { itemForRows ->
                Row (
                    modifier = Modifier
                        .fillMaxWidth(0.9f),
                    horizontalArrangement = Arrangement.spacedBy(screenWidth.dp * 0.10f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    itemForRows.forEachIndexed{index, item ->
                        ReleasedWatchListing(item.image, item.title, index, screenWidth.dp)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }

        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun ReleasedWatchListing(
    icon: Int,
    title: String,
    id: Int,
    screenWidth: Dp
) {
    Box(
        modifier = Modifier
            .width(screenWidth * 0.4f)
            .height(250.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = title,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                title,
                style = MaterialTheme.typography.displayMedium,
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Discover ->",
                style = MaterialTheme.typography.displaySmall
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                Text(
                    "Buy Now",
                    style = MaterialTheme.typography.displayMedium.copy(fontSize = 18.sp)
                )
            }
        }
    }
}
