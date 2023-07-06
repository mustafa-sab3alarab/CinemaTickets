@file:OptIn(ExperimentalFoundationApi::class)

package com.example.cinematickets.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.ui.theme.Orange80
import com.example.cinematickets.viewmodels.HomeUIState
import com.example.cinematickets.viewmodels.HomeViewModel
import kotlin.math.absoluteValue

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(state = state, pagerState = pagerState) { id ->
        navController.navigate("bookingScreen/$id")
    }
}


@Composable
private fun HomeContent(
    state: HomeUIState,
    pagerState: PagerState,
    onItemClickListener: (id : Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        BackgroundImage(state, pagerState)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Header()


            MoviePager(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, bottom = 16.dp),
                state = state,
                pagerState = pagerState
            ) { onItemClickListener(state.movies[pagerState.currentPage].id) }

            MovieDetails()

        }
    }
}

@Composable
private fun BackgroundImage(state: HomeUIState, pagerState: PagerState) {
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
}


@Composable
private fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(
            modifier = Modifier.padding(end = 8.dp),
            text = "Now Showing",
            textColor = Color.White,
            buttonColor = Orange80
        ) {}
        OutlineButton(text = "Coming Soon", textColor = Color.White) {}
    }
}

@Composable
private fun MoviePager(
    modifier: Modifier = Modifier,
    state: HomeUIState,
    pagerState: PagerState,
    onItemClickListener: () -> Unit
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
            Image(
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun MovieDetails() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "clock",
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = "2h 23m")
    }

    Text(
        modifier = Modifier.padding(vertical = 16.dp),
        text = "Fantastic Beasts: The\nSecrets of Dumbledore",
        fontSize = 22.sp,
        textAlign = TextAlign.Center
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(modifier = Modifier.padding(end = 8.dp), text = "Fantasy") {}
        OutlineButton(text = "Adventure") {}
    }
}