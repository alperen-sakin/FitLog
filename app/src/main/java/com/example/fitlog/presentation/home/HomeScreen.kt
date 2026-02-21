package com.example.fitlog.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fitlog.presentation.home.component.DaysBox
import com.example.fitlog.presentation.home.component.ExerciseCard
import com.example.fitlog.presentation.home.component.ProgressCard
import com.example.fitlog.presentation.home.component.TopAppBar
import com.example.fitlog.presentation.home.viewModel.HomeViewModel

@Composable
fun HomeScreen(
    // navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            DaysBox(
                modifier = Modifier,
                selectedDay = state.value.selectedDay,
                onDaySelected = viewModel::onDaySelected
            )

            ProgressCard(
                modifier = Modifier.padding(horizontal = 16.dp),
                leftExercises = state.value.leftExercise,
                progress = state.value.currentProgress
            )

            LazyColumn(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.value.exercises) { exercise ->
                    ExerciseCard(
                        onCardClick = viewModel::onCardClick,
                        exercise = exercise,
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
