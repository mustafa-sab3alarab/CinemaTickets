@file:OptIn(ExperimentalFoundationApi::class)

package com.example.cinematickets.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.ContentOverlay
import com.example.cinematickets.composable.MoviePager
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.screens.booking.navigateToBookingScreen
import com.example.cinematickets.screens.home.composable.HomeScreenHeader

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState()
    HomeContent(state = state, pagerState = pagerState) { id ->
        navController.navigateToBookingScreen(id)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUIState,
    pagerState: PagerState,
    onItemClickListener: (id: Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {

        ContentOverlay {
            Image(
                modifier = Modifier.fillMaxSize().blur(40.dp),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(model = state.movies[pagerState.currentPage].imageUrl),
                contentDescription = ""
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HomeScreenHeader()


            MoviePager(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, bottom = 16.dp),
                state = state,
                pagerState = pagerState,
                onItemClickListener = { onItemClickListener(state.movies[pagerState.currentPage].id) }) { page ->
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                    contentDescription = ""
                )
            }

            MovieDetails()

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