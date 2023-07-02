package com.example.cinematickets.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import com.example.cinematickets.R
import com.example.cinematickets.composable.ActorItem
import com.example.cinematickets.composable.ImageButton
import com.example.cinematickets.composable.MovieTextDetails
import com.example.cinematickets.composable.OutlineButton
import com.example.cinematickets.composable.SpacerHorizontal8
import com.example.cinematickets.composable.SpacerVertical16
import com.example.cinematickets.ui.theme.Orange80
import com.example.cinematickets.util.Constant.DEFAULT_IMAGE

@Composable
fun BookingScreen() {
    BookingContent()
}
@Composable
private fun BookingContent() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (header , bottomSheet) = createRefs()

        val guideLine = createGuidelineFromTop(0.5f)
        Header(
            modifier = Modifier.constrainAs(header){
                top.linkTo(parent.top)
            }
        )
        BottomSheet(
            modifier = Modifier.constrainAs(bottomSheet){
                top.linkTo(guideLine)
            }
        )
    }
//    Box(modifier = Modifier.fillMaxSize()) {
//        Header(modifier = Modifier.align(Alignment.TopCenter))
//        BottomSheet(modifier = Modifier.align(Alignment.BottomCenter))
//    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(modifier = modifier.aspectRatio(4f / 5f)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = "https://www.chicklit.nl/ckfinder/userfiles/images/Chicklit/artikelen/Films/Fantastic%20Beasts-%20The%20Secrets%20of%20Dumbledore%20-%20Dumbledore.jpeg"),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )

        Toolbar()

        ImageButton(
            painter = R.drawable.play,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center),
            backgroundColor = Orange80
        ) {}
    }
}

@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageButton(painter = R.drawable.close_circle) {}
        ImageButton(painter = R.drawable.clock, text = "2h 23m") {}
    }
}

@Composable
private fun BottomSheet(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
            .background(Color.White)
    ) {
        BottomSheetContent()
    }
}

@Composable
private fun BottomSheetContent() {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    MovieTextDetails(title = "6.8/10", subtitle = "IMDb")
                    MovieTextDetails(title = "63%", subtitle = "Rotten Tomatoes")
                    MovieTextDetails(title = "4/10", subtitle = "IGN")
                }

                SpacerVertical16()
                Text(
                    text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlineButton(text = "Fantasy") {}
            SpacerHorizontal8()
            OutlineButton(text = "Adventure") {}
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(20) { ActorItem(imageUrl = DEFAULT_IMAGE) }
        }

        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = stringResource(R.string.booking_screen_content),
                fontSize = 12.sp,
                lineHeight = 15.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            ImageButton(
                painter = R.drawable.bitcoin_card,
                backgroundColor = Orange80,
                text = "Booking",
                textSize = 16
            ) {

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewBookingScreen() {
    BookingScreen()
}