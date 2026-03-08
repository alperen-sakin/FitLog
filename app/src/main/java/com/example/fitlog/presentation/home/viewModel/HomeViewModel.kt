package com.example.fitlog.presentation.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.domain.repository.ExercisesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val LNG = 5000L

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ExercisesRepository
) : ViewModel() {

    private val _selectedDay = MutableStateFlow(Days.Mon)

    @OptIn(ExperimentalCoroutinesApi::class)
    val state: StateFlow<HomeState> = _selectedDay
        .flatMapLatest { day ->

            repository.getExercisesByDay(day.name).map { exerciseList ->
                HomeState(
                    selectedDay = day,
                    exercises = exerciseList
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(LNG),
            initialValue = HomeState()
        )

    fun onDaySelected(day: Days) {
        _selectedDay.value = day
    }

    fun onCardClick(exercise: Exercise) {
        viewModelScope.launch {
            val updatedExercise = exercise.copy(done = !exercise.done)
            repository.insertUseExercises(updatedExercise)
        }
    }
}
