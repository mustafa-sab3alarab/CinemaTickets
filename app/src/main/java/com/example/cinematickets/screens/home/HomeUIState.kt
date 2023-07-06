package com.example.cinematickets.screens.home

data class HomeUIState(
    val movies: List<MovieUIState> = emptyList()
)

data class MovieUIState(val id: Int, val imageUrl: String)