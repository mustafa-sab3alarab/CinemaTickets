package com.example.cinematickets.screens

import com.example.cinematickets.screens.home.MovieUIState

object DataSource {

    fun newShowingMovies(): List<MovieUIState> {
        return listOf(
            MovieUIState(
                0,
                "https://www.chicklit.nl/ckfinder/userfiles/images/Chicklit/artikelen/Films/Fantastic%20Beasts-%20The%20Secrets%20of%20Dumbledore%20-%20Dumbledore.jpeg"
            ),
            MovieUIState(1, "https://m.media-amazon.com/images/I/71lADxngTWS._AC_SL1050_.jpg"),
            MovieUIState(
                2,
                "https://files.ekmcdn.com/allwallpapers/images/captain-marvel-epic-61x91-5cm-movie-poster-31596-1-p.jpg?v=599d4741-9423-4652-b292-e55e0354b409"
            ),
            MovieUIState(
                3,
                "https://s.yimg.com/ny/api/res/1.2/KAcBiAjfBGsEsOhT0fbw7w--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTEzOTE7Y2Y9d2VicA--/https://media.zenfs.com/en/homerun/feed_manager_auto_publish_494/d05a3f087fa57f6d41b865d53a42a5f5"
            ),
            MovieUIState(4, "https://m.media-amazon.com/images/I/81F5PF9oHhL._AC_SY879_.jpg"),
        )
    }
}