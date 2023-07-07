package com.example.cinematickets.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.screens.home.HomeUIState
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviePager(
    modifier: Modifier = Modifier,
    state: HomeUIState,
    pagerState: PagerState,
    onItemClickListener: () -> Unit,
    content : @Composable (page : Int) -> Unit
) {
    HorizontalPager(
        modifier = modifier,
        pageCount = state.movies.size,
        state = pagerState,
        contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
        pageSpacing = 16.dp
    ) { page ->
        Card(
            modifier = Modifier
                .aspectRatio(4f / 5.5f)
                .clickable { onItemClickListener() }
                .graphicsLayer {
                    val pageOffset =
                        ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                    alpha = lerp(
                        start = 0.7f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                    scaleY = lerp(
                        start = 0.8f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
                },
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            content(page)
        }
    }
}