package com.example.fitlog.presentation.addScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitlog.domain.model.Days
import com.example.fitlog.domain.model.Exercise
import com.example.fitlog.domain.repository.ExercisesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val exercisesRepository: ExercisesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AddScreenState())
    val state = _state.asStateFlow()

    init {
        loadExercises()
    }

    private fun loadExercises() {
        val exercises = exercisesRepository.getExercises()
        _state.update { it.copy(exercises = exercises) }
    }

    fun onUpdateExercise(exercise: Exercise, updateType: UpdateType) {
        _state.update { currentState ->
            val updatedList = currentState.exercises.map { item ->
                if (item.name == exercise.name) {
                    when (updateType) {
                        UpdateType.SET_PLUS -> item.copy(set = item.set + 1)
                        UpdateType.SET_MINUS -> item.copy(set = (item.set - 1).coerceAtLeast(0))
                        UpdateType.REP_PLUS -> item.copy(rep = item.rep + 1)
                        UpdateType.REP_MINUS -> item.copy(rep = (item.rep - 1).coerceAtLeast(0))
                        UpdateType.TIME_PLUS -> item.copy(time = item.time + 5)
                        UpdateType.TIME_MINUS -> item.copy(time = (item.time - 5).coerceAtLeast(0))
                    }
                } else {
                    item
                }
            }
            currentState.copy(exercises = updatedList)
        }
    }
    fun onDaySelected(exercise: Exercise, day: Days) {
        _state.update { currentState ->
            val currentSelected = currentState.selectedDaysMap[exercise.name] ?: emptySet()
            val newSelected = if (currentSelected.contains(day)) {
                currentSelected - day
            } else {
                currentSelected + day
            }

            currentState.copy(
                selectedDaysMap = currentState.selectedDaysMap + (exercise.name to newSelected)
            )
        }
    }

    fun saveExercise(exercise: Exercise) {
        viewModelScope.launch {
            val selectedDays = _state.value.selectedDaysMap[exercise.name] ?: setOf(Days.Mon)

            selectedDays.forEach { day ->
                val exerciseToSave = exercise.copy(
                    id = 0,
                    day = day.name,
                    done = false
                )
                exercisesRepository.insertUseExercises(exerciseToSave)
            }
            _state.update { it.copy(isSaved = true) }
        }
    }

    enum class UpdateType {
        SET_PLUS, SET_MINUS, REP_PLUS, REP_MINUS, TIME_PLUS, TIME_MINUS
    }
}
