package com.example.cinematickets.viewmodels

import androidx.lifecycle.ViewModel
import com.example.cinematickets.screens.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(HomeUIState())
    val state = _state.asStateFlow()

    init {
        getMovies()
    }

    private fun getMovies() {
        _state.update { it.copy(movies = DataSource.newShowingMovies()) }
    }



}