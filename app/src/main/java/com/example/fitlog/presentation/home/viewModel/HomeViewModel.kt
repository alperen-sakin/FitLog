package com.example.fitlog.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onDaySelected(day: Days) {
        _state.update { it.copy(selectedDay = day) }
    }

    fun onCardClick(exercise: Exercise) {
        _state.update { currentState ->
            val updatedExercises = currentState.exercises.map {
                if (it == exercise) {
                    it.copy(done = !it.done)
                } else {
                    it
                }
            }

            currentState.copy(
                exercises = updatedExercises,
            )
        }
    }
}
