package com.example.cinematickets.viewmodels

data class HomeUIState(
    val movies: List<MovieUIState> = emptyList()
)

data class MovieUIState(val id: Int, val imageUrl: String)