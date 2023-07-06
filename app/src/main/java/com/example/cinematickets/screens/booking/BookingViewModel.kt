package com.example.cinematickets.screens.booking

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematickets.screens.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(BookingUIState())
    val state = _state.asStateFlow()

    private val args = BookingArgs(savedStateHandle)

    init {
        _state.update { state ->
            state.copy(
                image = "${
                    DataSource.newShowingMovies().find {
                        it.id == args.imageId.toString().toInt()
                    }?.imageUrl
                }"
            )
        }
    }
}