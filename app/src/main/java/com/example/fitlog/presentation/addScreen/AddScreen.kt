package com.example.fitlog.presentation.addScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fitlog.presentation.addScreen.component.SelectExerciseBox
import com.example.fitlog.presentation.addScreen.viewModel.AddScreenViewModel

@Composable
fun AddScreen(
    viewModel: AddScreenViewModel = hiltViewModel(),
    // navController: NavController
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    Scaffold {
        LazyColumn(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            items(state.value.exercises) { exercise ->
                SelectExerciseBox(
                    exercise = exercise,
                    modifier = Modifier
                        .padding(8.dp),
                    onUpdate = { updateType ->
                        viewModel.onUpdateExercise(exercise, updateType)
                    }

                )
            }
        }
    }
}
