@file:OptIn(ExperimentalFoundationApi::class)

package com.example.cinematickets.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.composable.SpacerHorizontal8
import com.example.cinematickets.composable.SpacerVertical16
import com.example.cinematickets.composable.SpacerVertical32
import com.example.cinematickets.ui.theme.Orange80
import com.example.cinematickets.viewmodels.HomeUIState
import com.example.cinematickets.viewmodels.HomeViewModel
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    val selectedItem by remember { mutableStateOf(0) }
    val navItems by remember { mutableStateOf(listOf("Songs", "Artists", "Playlists")) }
    val navIcons by remember { mutableStateOf(listOf(R.drawable.bitcoin_card, R.drawable.play)) }
    HomeContent(
        state = state,
        pagerState = pagerState,
        navSelectedItem = selectedItem,
        navItems,
        navIcons
    )
}


@Composable
fun HomeContent(
    state: HomeUIState,
    pagerState: PagerState,
    navSelectedItem: Int,
    navItems: List<String>,
    navIcons: List<Int>,
) {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            modifier = Modifier
                .fillMaxSize()
                .blur(40.dp),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(model = state.movies[pagerState.currentPage].imageUrl),
            contentDescription = ""
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Transparent,
                            Color.White,
                            Color.White
                        )
                    )
                )
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlineButton(
                    text = "Now Showing",
                    textColor = Color.White,
                    buttonColor = Orange80
                ) {}
                SpacerHorizontal8()
                OutlineButton(text = "Coming Soon", textColor = Color.White) {}
            }

            SpacerVertical32()
            MoviePager(
                modifier = Modifier
                    .fillMaxWidth(),
                state = state, pagerState = pagerState
            )

            SpacerVertical16()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.clock), contentDescription = "clock")
                SpacerHorizontal8()
                Text(text = "2h 23m")
            }

            SpacerVertical16()

            Text(
                text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )

            SpacerVertical16()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlineButton(text = "Fantasy") {}
                SpacerHorizontal8()
                OutlineButton(text = "Adventure") {}
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter).padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ImageButton(
                painter = R.drawable.video_play,
                modifier = Modifier.size(48.dp),
                backgroundColor = Orange80
            ) {}
            ImageButton(
                painter = R.drawable.search_normal,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
            ImageButton(
                painter = R.drawable.ticket,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
            ImageButton(
                painter = R.drawable.profile,
                modifier = Modifier.size(48.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
        }
    }
}

@Composable
fun MoviePager(modifier: Modifier = Modifier, state: HomeUIState, pagerState: PagerState) {
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
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                contentDescription = ""
            )
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}